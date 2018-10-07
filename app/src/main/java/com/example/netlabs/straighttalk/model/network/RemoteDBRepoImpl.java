package com.example.netlabs.straighttalk.model.network;

import android.net.Uri;
import android.util.Log;

import com.example.netlabs.straighttalk.model.database.BursaryDBRepository;
import com.example.netlabs.straighttalk.model.database.entities.Course;
import com.example.netlabs.straighttalk.model.database.entities.Hostel;
import com.example.netlabs.straighttalk.model.database.entities.Institution;
import com.example.netlabs.straighttalk.model.database.entities.School;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;
import com.example.netlabs.straighttalk.model.database.entities.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RemoteDBRepoImpl implements BursaryRemoteRepository {

    private BursaryDBRepository dbRepo;

    private static final String LOG_TAG = RemoteDBRepoImpl.class.getSimpleName();
    private static final String BASE_URL = "http://80.85.86.151/stalk/public/student/auth/api";

    public RemoteDBRepoImpl(BursaryDBRepository dbRepo) {
        this.dbRepo = dbRepo;
    }

    @Override
    public void downloadCoursesFromRemote() {
        URL requestUrl = buildRequestURL("getcourses");
        String jsonResponse = null;
        if (requestUrl != null) jsonResponse = makeAPICall("GET", requestUrl);
        insertCoursesIntoDB(jsonResponse);
    }

    private URL buildRequestURL(String endpoint) {
        try {
            Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                    .appendPath(endpoint).build();
            return new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Exception error: ", e);
            return null;
        }
    }

    private void insertCoursesIntoDB(String jsonResponse) {
        try {
            JSONObject coursesJson = new JSONObject(jsonResponse);
            JSONArray coursesJ = coursesJson.getJSONArray("courses");
            JSONObject courseJ; Course course;
            ArrayList<Course> courses = new ArrayList<>();

            for (int i = 0; i < coursesJ.length(); i++) {
                courseJ = coursesJ.getJSONObject(i);
                course = new Course();

                course.setName(courseJ.getString("name"));
                course.setCategory(courseJ.getString("category"));
                course.setLevel(courseJ.getString("level"));

                courses.add(course);
            }

            dbRepo.insertCourse((Course[]) courses.toArray());
        } catch (JSONException e) {
            Log.e(LOG_TAG, "JSON parsing failed: " + jsonResponse, e);
        }
    }

    @Override
    public void downloadSchoolsFromRemote() {
        URL requestUrl = buildRequestURL("getschools");
        String jsonResponse = null;
        if (requestUrl != null) jsonResponse = makeAPICall("GET", requestUrl);
        insertSchoolsIntoDB(jsonResponse);
    }

    private void insertSchoolsIntoDB(String jsonResponse) {
        try {
            JSONObject schoolsJson = new JSONObject(jsonResponse);
            JSONArray schoolsJ = schoolsJson.getJSONArray("schools");
            JSONObject schoolJ; School school;
            ArrayList<School> schools = new ArrayList<>();

            for (int i = 0; i < schoolsJ.length(); i++) {
                schoolJ = schoolsJ.getJSONObject(i);
                school = new School();

                school.setSchoolName(schoolJ.getString("school_name"));
                school.setLevel(schoolJ.getString("level"));

                schools.add(school);
            }

            dbRepo.insertSchool((School[]) schools.toArray());
        } catch (JSONException e) {
            Log.e(LOG_TAG, "JSON parsing failed: " + jsonResponse, e);
        }
    }

    @Override
    public void downloadHostelsFromRemote() {
        URL requestUrl = buildRequestURL("gethostels");
        String jsonResponse = null;
        if (requestUrl != null) jsonResponse = makeAPICall("GET", requestUrl);
        insertHostelsIntoDB(jsonResponse);
    }

    private void insertHostelsIntoDB(String jsonResponse) {
        try {
            JSONObject hostelsJson = new JSONObject(jsonResponse);
            JSONArray hostelsJ = hostelsJson.getJSONArray("hostels");
            JSONObject hostelJ; Hostel hostel;
            ArrayList<Hostel> hostels = new ArrayList<>();

            for (int i = 0; i < hostelsJ.length(); i++) {
                hostelJ = hostelsJ.getJSONObject(i);
                hostel = new Hostel();

                hostel.setName(hostelJ.getString("hostel_name"));

                hostels.add(hostel);
            }

            dbRepo.insertHostel((Hostel[]) hostels.toArray());
        } catch (JSONException e) {
            Log.e(LOG_TAG, "JSON parsing failed: " + jsonResponse, e);
        }
    }

    @Override
    public void uploadStudentPersonalDetailsToRemote() {
        List<Student> students = dbRepo.getAllStudents().getValue();
        if (students != null)
            for (Student student : students) {
                URL studentURL = buildStudentURL(student);
                String jsonResponse = null;
                if (studentURL != null) jsonResponse = makeAPICall("POST", studentURL);
                String bursaryID = getBursaryIDFromResponse(jsonResponse);
                student.setBursaryID(bursaryID);
                dbRepo.updateStudent(student);
            }
    }

    private URL buildStudentURL(Student student) {
        final String createStudentAPIEndpoint = "createstudent";
        try {

            Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                    .appendPath(createStudentAPIEndpoint)
                    .appendQueryParameter("name", student.getName())
                    .appendQueryParameter("dob", student.getDob())
                    .appendQueryParameter("level", student.getLevel())
                    .appendQueryParameter("gender", student.getGender())
                    .appendQueryParameter("ethnicity", student.getEthnicity())
                    .appendQueryParameter("entry_grade", Integer.toString(student.getEntryGrade()))
                    .appendQueryParameter("student_phone", student.getStudentPhone())
                    .appendQueryParameter("national_id", student.getNationalID())
                    .appendQueryParameter("registration_year", student.getYearOfRegistration())
                    .appendQueryParameter("year_start", student.getYearOfStartAtInstitution())
                    .appendQueryParameter("year_stop", student.getYearOfEndAtInstitution())
                    .appendQueryParameter("uce_grade", student.getUCEGrade())
                    .appendQueryParameter("uace_grade", student.getUACEGrade())
                    .appendQueryParameter("student_email", student.getStudentEmail())
                    .appendQueryParameter("parent1_name", student.getParent1Name())
                    .appendQueryParameter("parent1_phone", student.getParent1Phone())
                    .appendQueryParameter("parent2_name", student.getParent2Name())
                    .appendQueryParameter("parent2_phone", student.getParent2Phone())
                    .appendQueryParameter("dist_name", student.getDistrictName())
                    .appendQueryParameter("subcounty", student.getSubCounty())
                    .appendQueryParameter("village", student.getVillage())
                    .appendQueryParameter("current_state", student.getCurrentState())
                    .appendQueryParameter("dropout_reason", student.getDropoutReason())
                    .appendQueryParameter("comments", student.getComments())
                    .appendQueryParameter("notes", student.getNotes())
                    .appendQueryParameter("funder", student.getFunder())
                    .build();

            Log.d(LOG_TAG, "Built Students URI: " + builtUri.toString());

            return new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Exception error: ", e);
            return null;
        }
    }

    private String getBursaryIDFromResponse(String jsonResponse) {
        String bursaryID;
        try {
            JSONObject response = new JSONObject(jsonResponse);
            String bursaryIDKey = "bursary_id"; // TODO add bursary_id 2 API response
            bursaryID = response.getString(bursaryIDKey);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "JSON parsing failed", e);
            bursaryID = null;
        }
        return bursaryID;
    }

    @Override
    public void uploadSecondarySchoolStudentInfoToRemote() {
        List<Student> students = dbRepo.getAllStudents().getValue();
        if (students != null)
            for (Student student : students) {
                URL secondaryURL = buildSecondarySchoolInfoURL(student);
                String jsonResponse;
                if (secondaryURL != null) {
                    jsonResponse = makeAPICall("POST", secondaryURL);
                    checkOKFromResponse(jsonResponse, secondaryURL.toString());
                }
            }
    }

    private String getSchoolNameOfStudent(Student student) {
        int studentId = student.getId();
        Secondary secondaryInfo = dbRepo.getSecondaryInfo(studentId);
        int schoolId = secondaryInfo.getSchool();
        School school = dbRepo.getSchool(schoolId);
        return school.getSchoolName();
    }

    private URL buildSecondarySchoolInfoURL(Student student) {
        final String createSecondarySchoolInfoAPIEndpoint = "createsecondaryinfo";
        int studentId = student.getId();
        Secondary secondaryInfo = dbRepo.getSecondaryInfo(studentId);
        try {

            Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                    .appendPath(createSecondarySchoolInfoAPIEndpoint)
                    .appendQueryParameter("school_name", getSchoolNameOfStudent(student))
                    .appendQueryParameter("bursary_id", student.getBursaryID())
                    .appendQueryParameter("s_form", secondaryInfo.getForm())
                    .appendQueryParameter("stream", secondaryInfo.getStream())
                    .appendQueryParameter("student_index", secondaryInfo.getStudentIndex())
                    .build();

            Log.d(LOG_TAG, "Built Secondary school info URI: " + builtUri.toString());

            return new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Exception error: ", e);
            return null;
        }
    }

    private void checkOKFromResponse(String jsonResponse, String requestURL) {
        try {
            JSONObject response = new JSONObject(jsonResponse);
            boolean error = response.getBoolean("error");
            if (!error)
                Log.d(LOG_TAG, "Successful insertion: " + requestURL);
            else
                Log.d(LOG_TAG, "The upload failed: " + requestURL);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "JSON parsing failed: " + jsonResponse, e);
        }
    }

    @Override
    public void uploadInstitutionStudentInfoToRemote() {
        List<Student> students = dbRepo.getAllStudents().getValue();
        if (students != null)
            for (Student student : students) {
                URL institutionURL = buildInstitutionInfoURL(student);
                String jsonResponse;
                if (institutionURL != null) {
                    jsonResponse = makeAPICall("POST", institutionURL);
                    checkOKFromResponse(jsonResponse, institutionURL.toString());
                }
            }
    }

    private String getHostelNameOfStudent(Student student) {
        int studentId = student.getId();
        Institution institutionInfo = dbRepo.getInstitutionInfo(studentId);
        int hostelId = institutionInfo.getHostel();
        Hostel hostel = dbRepo.getHostel(hostelId);
        return hostel.getName();
    }

    private String getCourseNameOfStudent(Student student) {
        int studentId = student.getId();
        Institution institutionInfo = dbRepo.getInstitutionInfo(studentId);
        int courseId = institutionInfo.getCourse();
        Course course = dbRepo.getCourse(courseId);
        return course.getName();
    }

    private URL buildInstitutionInfoURL(Student student) {
        final String createInstitutionInfoEndpoint = "createinstitutioninfo";
        int studentId = student.getId();
        Institution institutionInfo = dbRepo.getInstitutionInfo(studentId);
        try {

            Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                    .appendPath(createInstitutionInfoEndpoint)
                    .appendQueryParameter("institution_name", getSchoolNameOfStudent(student))
                    .appendQueryParameter("bursary_id", student.getBursaryID())
                    .appendQueryParameter("hostel_name", getHostelNameOfStudent(student))
                    .appendQueryParameter("course_name", getCourseNameOfStudent(student))
                    .appendQueryParameter("qualification", institutionInfo.getQualification())
                    .appendQueryParameter("student_number", institutionInfo.getStudentNumber())
                    .appendQueryParameter("registration_number",
                            institutionInfo.getRegistrationNumber())
                    .appendQueryParameter("student_bank_name", institutionInfo.getStudentBankName())
                    .appendQueryParameter("student_bank_account",
                            institutionInfo.getStudentBankAccount())
                    .appendQueryParameter("student_bank_address",
                            institutionInfo.getStudentBankAddress())
                    .appendQueryParameter("other_bank_name", institutionInfo.getOtherBankName())
                    .appendQueryParameter("other_bank_account",
                            institutionInfo.getOtherBankAccount())
                    .appendQueryParameter("other_bank_address",
                            institutionInfo.getOtherBankAddress())
                    .build();

            Log.d(LOG_TAG, "Built Institution info URI: " + builtUri.toString());

            return new URL(builtUri.toString());

        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Exception error: ", e);
            return null;
        }
    }

    private String makeAPICall(String method, URL url) {
        // 1. Connect to the url
        // 2. Get the response as a JSON string
        // 3. Return that string

        // These two need to be declared outside the try/catch
        // so that they can be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // Will contain the raw JSON response as a string.
        String jsonStrResponse;

        try{
            // Create the request to Bursary DB, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(method); // GET or POST
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line).append("\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }

            jsonStrResponse = buffer.toString();
            Log.d(LOG_TAG, "RemoteDB JSON String response: " + jsonStrResponse);

            inputStream.close();

        } catch(IOException e) {
            Log.e(LOG_TAG, "IOException error: ", e);
            jsonStrResponse = null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing reader", e);
                }
            }
        }
        return jsonStrResponse;
    }
}
