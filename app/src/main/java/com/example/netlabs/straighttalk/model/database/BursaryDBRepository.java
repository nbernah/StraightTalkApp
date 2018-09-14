package com.example.netlabs.straighttalk.model.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.netlabs.straighttalk.model.database.DAOs.CourseDAO;
import com.example.netlabs.straighttalk.model.database.DAOs.HostelDAO;
import com.example.netlabs.straighttalk.model.database.DAOs.InstitutionDAO;
import com.example.netlabs.straighttalk.model.database.DAOs.SchoolDAO;
import com.example.netlabs.straighttalk.model.database.DAOs.StudentDAO;
import com.example.netlabs.straighttalk.model.database.entities.Course;
import com.example.netlabs.straighttalk.model.database.entities.Hostel;
import com.example.netlabs.straighttalk.model.database.entities.Institution;
import com.example.netlabs.straighttalk.model.database.entities.School;
import com.example.netlabs.straighttalk.model.database.entities.Student;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;
import com.example.netlabs.straighttalk.model.database.DAOs.SecondaryDAO;

import java.util.List;

public class BursaryDBRepository {

    private InstitutionDAO institutionDAO;
    private LiveData<List<Institution>> allInstitutions;

    private SecondaryDAO secondaryDAO;
    private LiveData<List<Secondary>> allSecondaries;

    private StudentDAO studentDAO;
    private LiveData<List<Student>> allStudents;

    private SchoolDAO schoolDAO;
    private LiveData<List<School>> allSchools;

    private CourseDAO courseDAO;
    private LiveData<List<Course>> allCourses;

    private HostelDAO hostelDAO;
    private LiveData<List<Hostel>> allHostels;

    private static BursaryDBRepository INSTANCE;

    private BursaryDBRepository(Application app) {
        BursaryDatabase db = BursaryDatabase.getDatabase(app);

        institutionDAO = db.institutionsDAO();
        allInstitutions = institutionDAO.getAllInstitutions();

        secondaryDAO = db.secondaryDAO();
        allSecondaries = secondaryDAO.getAllSecondaries();

        studentDAO = db.studentDAO();
        allStudents = studentDAO.getAllStudents();

        schoolDAO = db.schoolDAO();
        allSchools = schoolDAO.getAllSchools();

        courseDAO = db.courseDAO();
        allCourses = courseDAO.getAllCourses();

        hostelDAO = db.hostelDAO();
        allHostels = hostelDAO.getAllHostels();
    }

    public static BursaryDBRepository getRepository(Application app) {
        if (INSTANCE == null) {
            synchronized (BursaryDBRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BursaryDBRepository(app);
                }
            }
        }
        return INSTANCE;
    }

    public void insertInstitution(Institution... institutions) {
        new InsertInstitutionAsyncTask(institutionDAO).execute(institutions);
    }

    public void insertStudent(Student... students){
        new InsertStudentAsyncTask(studentDAO).execute(students);
    }

    public void insertSecondary(Secondary... secondaries){
        new InsertSecondaryAsyncTask(secondaryDAO).execute(secondaries);
    }

    public void insertSchool(School... schools) {
        new InsertSchoolAsyncTask(schoolDAO).execute(schools);
    }

    public void insertCourse(Course... courses) {
        new InsertCourseAsyncTask(courseDAO).execute(courses);
    }

    public void insertHostel(Hostel... hostels) {
        new InsertHostelAsyncTask(hostelDAO).execute(hostels);
    }

    public LiveData<List<Institution>> getAllInstitutions() {
        return allInstitutions;
    }

    public LiveData<List<Secondary>> getAllSecondaries() {
        return allSecondaries;
    }

    public LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }

    public LiveData<List<School>> getAllSchools() {
        return allSchools;
    }

    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    public LiveData<List<Hostel>> getAllHostels() {
        return allHostels;
    }

    public void updateStudent(Student... students) {
        new UpdateStudentAsyncTask(studentDAO).execute(students);
    }

    public void updateInstitution(Institution... institutions) {
        new UpdateInstitutionAsyncTask(institutionDAO).execute(institutions);
    }

    public void updateSecondary(Secondary... secondaries) {
        new UpdateSecondaryAsyncTask(secondaryDAO).execute(secondaries);
    }

    public void updateSchool(School... schools) {
        new UpdateSchoolAsyncTask(schoolDAO).execute(schools);
    }

    public void updateCourse(Course... courses) {
        new UpdateCourseAsyncTask(courseDAO).execute(courses);
    }

    public void updateHostel(Hostel... hostels) {
        new UpdateHostelAsyncTask(hostelDAO).execute(hostels);
    }

    public void deleteStudent(Integer... idz) {
        new DeleteStudentAsyncTask(studentDAO).execute(idz);
    }

    public void deleteInstitution(Integer... idz) {
        new DeleteInstitutionAsyncTask(institutionDAO).execute(idz);
    }

    public void deleteSecondary(Integer... idz) {
        new DeleteSecondaryAsyncTask(secondaryDAO).execute(idz);
    }

    public void deleteSchool(Integer... idz) {
        new DeleteSchoolAsyncTask(schoolDAO).execute(idz);
    }

    public void deleteCourse(Integer... idz) {
        new DeleteCourseAsyncTask(courseDAO).execute(idz);
    }

    public void deleteHostel(Integer... idz) {
        new DeleteHostelAsyncTask(hostelDAO).execute(idz);
    }

    private static class InsertInstitutionAsyncTask extends AsyncTask<Institution,Void,Void> {

        InstitutionDAO institutionDAO;
        InsertInstitutionAsyncTask(InstitutionDAO institutionDAO) {
            this.institutionDAO = institutionDAO;
        }

        @Override
        protected Void doInBackground(Institution... institutions) {
            for (Institution institution : institutions)
                institutionDAO.insertInstitution(institution);
            return null;
        }
    }

    private static class InsertStudentAsyncTask extends AsyncTask<Student, Void, Void> {

        StudentDAO studentDAO;

        InsertStudentAsyncTask(StudentDAO studentDAO) {
            this.studentDAO = studentDAO;
        }

        @Override
        protected Void doInBackground(Student... students) {
            for (Student student : students)
                studentDAO.insertStudent(student);
            return null;
        }
    }

    private static class InsertSecondaryAsyncTask extends AsyncTask<Secondary, Void, Void> {
        private SecondaryDAO secondaryDAO;

        InsertSecondaryAsyncTask(SecondaryDAO dao) {
            this.secondaryDAO = dao;
        }

        @Override
        protected Void doInBackground(Secondary... secondaries) {
            for (Secondary secondarySchool : secondaries)
                secondaryDAO.insertSecondary(secondarySchool);
            return null;
        }
    }

    private static class InsertSchoolAsyncTask extends AsyncTask<School, Void, Void> {
        private SchoolDAO schoolDAO;

        InsertSchoolAsyncTask(SchoolDAO schoolDAO) {
            this.schoolDAO = schoolDAO;
        }

        @Override
        protected Void doInBackground(School... schools) {
            for (School school : schools)
                schoolDAO.insertSchool(school);
            return null;
        }
    }

    private static class InsertCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDAO courseDAO;

        InsertCourseAsyncTask(CourseDAO courseDAO) {
            this.courseDAO = courseDAO;
        }

        @Override
        protected Void doInBackground(Course... courses) {
            for (Course course : courses)
                courseDAO.insertCourse(course);
            return null;
        }
    }

    private static class InsertHostelAsyncTask extends AsyncTask<Hostel, Void, Void> {
        private HostelDAO hostelDAO;

        InsertHostelAsyncTask(HostelDAO hostelDAO) {
            this.hostelDAO = hostelDAO;
        }

        @Override
        protected Void doInBackground(Hostel... hostels) {
            for (Hostel hostel : hostels)
                hostelDAO.insertHostel(hostel);
            return null;
        }
    }

    private static class UpdateStudentAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDAO studentDAO;

        UpdateStudentAsyncTask(StudentDAO studentDAO) {
            this.studentDAO = studentDAO;
        }

        @Override
        protected Void doInBackground(Student... students) {
            for (Student student : students)
                studentDAO.updateStudent(student);
            return null;
        }
    }

    private static class UpdateSecondaryAsyncTask extends AsyncTask<Secondary, Void, Void> {
        private SecondaryDAO secondaryDAO;

        UpdateSecondaryAsyncTask(SecondaryDAO secondaryDAO) {
            this.secondaryDAO = secondaryDAO;
        }

        @Override
        protected Void doInBackground(Secondary... secondaries) {
            for (Secondary secondary : secondaries)
                secondaryDAO.updateSecondary(secondary);
            return null;
        }
    }

    private static class UpdateSchoolAsyncTask extends AsyncTask<School, Void, Void> {
        private SchoolDAO schoolDAO;

        UpdateSchoolAsyncTask(SchoolDAO schoolDAO) {
            this.schoolDAO = schoolDAO;
        }

        @Override
        protected Void doInBackground(School... schools) {
            for (School school : schools)
                schoolDAO.updateSchool(school);
            return null;
        }
    }

    private static class UpdateInstitutionAsyncTask extends AsyncTask<Institution, Void, Void> {
        private InstitutionDAO institutionDAO;

        UpdateInstitutionAsyncTask(InstitutionDAO institutionDAO) {
            this.institutionDAO = institutionDAO;
        }

        @Override
        protected Void doInBackground(Institution... institutions) {
            for (Institution institution : institutions)
                institutionDAO.updateInstitution(institution);
            return null;
        }
    }

    private static class UpdateHostelAsyncTask extends AsyncTask<Hostel, Void, Void> {
        private HostelDAO hostelDAO;

        UpdateHostelAsyncTask(HostelDAO hostelDAO) {
            this.hostelDAO = hostelDAO;
        }

        @Override
        protected Void doInBackground(Hostel... hostels) {
            for (Hostel hostel : hostels)
                hostelDAO.updateHostel(hostel);
            return null;
        }
    }

    private static class UpdateCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDAO courseDAO;

        UpdateCourseAsyncTask(CourseDAO courseDAO) {
            this.courseDAO = courseDAO;
        }

        @Override
        protected Void doInBackground(Course... courses) {
            for (Course course : courses)
                courseDAO.updateCourse(course);
            return null;
        }
    }

    private static class DeleteStudentAsyncTask extends AsyncTask<Integer, Void, Void> {
        private StudentDAO studentDAO;

        DeleteStudentAsyncTask(StudentDAO studentDAO) {
            this.studentDAO = studentDAO;
        }

        @Override
        protected Void doInBackground(Integer... idz) {
            for (Integer id : idz)
                studentDAO.deleteStudent(id);
            return null;
        }
    }

    private static class DeleteSecondaryAsyncTask extends AsyncTask<Integer, Void, Void> {
        private SecondaryDAO secondaryDAO;

        DeleteSecondaryAsyncTask(SecondaryDAO secondaryDAO) {
            this.secondaryDAO = secondaryDAO;
        }

        @Override
        protected Void doInBackground(Integer... idz) {
            for (Integer id : idz)
                secondaryDAO.deleteSecondary(id);
            return null;
        }
    }

    private static class DeleteSchoolAsyncTask extends AsyncTask<Integer, Void, Void> {
        private SchoolDAO schoolDAO;

        DeleteSchoolAsyncTask(SchoolDAO schoolDAO) {
            this.schoolDAO = schoolDAO;
        }

        @Override
        protected Void doInBackground(Integer... idz) {
            for (Integer id : idz)
                schoolDAO.deleteSchool(id);
            return null;
        }
    }

    private static class DeleteInstitutionAsyncTask extends AsyncTask<Integer, Void, Void> {
        private InstitutionDAO institutionDAO;

        DeleteInstitutionAsyncTask(InstitutionDAO institutionDAO) {
            this.institutionDAO = institutionDAO;
        }

        @Override
        protected Void doInBackground(Integer... idz) {
            for (java.lang.Integer id : idz)
                institutionDAO.deleteInstitution(id);
            return null;
        }
    }

    private static class DeleteHostelAsyncTask extends AsyncTask<Integer, Void, Void> {
        private HostelDAO hostelDAO;

        DeleteHostelAsyncTask(HostelDAO hostelDAO) {
            this.hostelDAO = hostelDAO;
        }

        @Override
        protected Void doInBackground(Integer... idz) {
            for (Integer id : idz)
                hostelDAO.deleteHostel(id);
            return null;
        }
    }

    private static class DeleteCourseAsyncTask extends AsyncTask<Integer, Void, Void> {
        private CourseDAO courseDAO;

        DeleteCourseAsyncTask(CourseDAO courseDAO) {
            this.courseDAO = courseDAO;
        }

        @Override
        protected Void doInBackground(Integer... idz) {
            for (Integer id : idz)
                courseDAO.deleteCourse(id);
            return null;
        }
    }
}
