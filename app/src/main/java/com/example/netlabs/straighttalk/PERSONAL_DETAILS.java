package com.example.netlabs.straighttalk;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetails;
import com.example.netlabs.straighttalk.viewmodel.PersonalDetailsViewModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PERSONAL_DETAILS extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextStud_family_name;
    private EditText editTextStud_given_name;
    private EditText editTextDob;
    private Spinner spinnerGender;
    private EditText editTextEthnicity;
    private EditText editTextStudent_entry_grades;
    private EditText editTextStudent_phone_number;
    private EditText editTextStudent_email_address;
    private EditText editTextStudent_national_id;
    private EditText editTextyear_of_registration;
    private EditText editTextyear_of_start_at_school;
    private EditText editTextexpected_year_of_end_at_school;
    private EditText editTextuce;
    private EditText editTextuace;
    private EditText editTextParent1_family_name;
    private EditText editTextParent1_given_name;
    private EditText editTextParent1_phone_number;
    private EditText editTextParent2_family_name;
    private EditText editTextParent2_given_name;
    private EditText editTextParent2_phone_number;
    private Spinner spinnerDist_origin;
    private EditText editTextSub_county;
    private Spinner schoolTypeSpinner;
    private EditText editTextVillage_name;
    private EditText editTextCurrent_state;
    private EditText editTextDropout_reason;
    private EditText editTextNotes;


    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__details);

        editTextStud_family_name = findViewById(R.id.Stud_family_name);
        editTextStud_given_name = findViewById(R.id.Stud_given_name);
        editTextDob = findViewById(R.id.Dob);
        spinnerGender = findViewById(R.id.Gender);
        schoolTypeSpinner = findViewById(R.id.school_type);
        editTextEthnicity = findViewById(R.id.Ethnicity);
        editTextStudent_entry_grades = findViewById(R.id.Student_entry_grades);
        editTextStudent_national_id = findViewById(R.id.Student_national_id);
        editTextyear_of_registration = findViewById(R.id.year_of_registration);
        editTextyear_of_start_at_school = findViewById(R.id.year_of_start_at_shool);
        editTextexpected_year_of_end_at_school = findViewById(R.id.expected_year_of_end_at_school);
        editTextuce = findViewById(R.id.uce_grade);
        editTextuace = findViewById(R.id.uace);
        editTextStudent_phone_number = findViewById(R.id.Stud_contact_phone);
        editTextStudent_email_address = findViewById(R.id.Stud_contact_email);
        editTextParent1_family_name = findViewById(R.id.parent1_family_name);
        editTextParent1_given_name = findViewById(R.id.Parent1_given_name);
        editTextParent1_phone_number = findViewById(R.id.Parent1_contact);
        editTextParent2_family_name = findViewById(R.id.parent2_family_name);
        editTextParent2_given_name = findViewById(R.id.Parent2_given_name);
        editTextParent2_phone_number = findViewById(R.id.Parent2_contact);
        spinnerDist_origin = findViewById(R.id.Dist_origin);
        editTextSub_county = findViewById(R.id.Sub_county);
        editTextVillage_name = findViewById(R.id.Village_name);
        editTextCurrent_state = findViewById(R.id.Current_state);
        editTextDropout_reason = findViewById(R.id.Dropout_reason);
        editTextNotes = findViewById(R.id.Notes);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btn_next) {
//        startActivity(new Intent(this, List_View.class));
            String school = schoolTypeSpinner.getSelectedItem().toString();
            if (school.equals("Secondary"))
                startActivity(new Intent(this, SECONDARY.class)
                        .putExtras(buttonNext()));
            if (school.equals("University") || school.equals("Tertiary"))
                startActivity(new Intent(this, INSTITUTIONS.class)
                        .putExtras(buttonNext()));
        }
    }

    private Bundle buttonNext() {
        final String stud_family_name = editTextStud_family_name.getText().toString().trim();
        final String stud_given_name = editTextStud_given_name.getText().toString().trim();
        final String dob = editTextDob.getText().toString().trim();
        final String gender = spinnerGender.toString().trim();
        final String ethnicity = editTextEthnicity.getText().toString().trim();
        final String school = schoolTypeSpinner.getSelectedItem().toString();
        final String student_entry_grades = editTextStudent_entry_grades.getText().toString().trim();
        final String student_national_id = editTextStudent_national_id.getText().toString().trim();
        final String year_of_regstration = editTextyear_of_registration.getText().toString().trim();
        final String year_of_start_at_school = editTextyear_of_start_at_school.getText().toString().trim();
        final String expected_year_of_end_at_school= editTextexpected_year_of_end_at_school.getText().toString().trim();
        final String uce = editTextuce.getText().toString().trim();
        final String uace = editTextuace.getText().toString().trim();
        final String stud_contact_phone = editTextStudent_phone_number.getText().toString().trim();
        final String stud_contact_email = editTextStudent_email_address.getText().toString().trim();
        final String parent1_family_name = editTextParent1_family_name.getText().toString().trim();
        final String parent1_given_name = editTextParent1_given_name.getText().toString().trim();
        final String parent1_contact = editTextParent1_phone_number.getText().toString().trim();
        final String parent2_family_name = editTextParent2_family_name.getText().toString().trim();
        final String parent2_given_name = editTextParent2_given_name.getText().toString().trim();
        final String parent2_contact = editTextParent2_phone_number.getText().toString().trim();
        final String dist_origin = "kla"; // spinnerDist_origin.toString().trim();
        final String sub_county = "rubaga"; // spinnerSub_county.toString().trim();
        final String village_name = editTextVillage_name.getText().toString().trim();
        final String current_state = editTextCurrent_state.getText().toString().trim();
        final String dropout_reason = editTextDropout_reason.getText().toString().trim();
        final String notes = editTextNotes.getText().toString().trim();

        Bundle b = new Bundle();
        b.putString("sfn", stud_family_name);
        b.putString("sgn", stud_given_name);
        b.putString("dob", dob);
        b.putString("gender", gender);
        b.putString("sch", school);
        b.putString("ethn", ethnicity);
        b.putString("entgrd", student_entry_grades);
        b.putString("stdphn", stud_contact_phone);
        b.putString("nId", student_national_id);
        b.putString("regyr", year_of_regstration);
        b.putString("ctmail", stud_contact_email);
        b.putString("yos", year_of_start_at_school);
        b.putString("yoe", expected_year_of_end_at_school);
        b.putString("uce", uce);
        b.putString("uace", uace);
        b.putString("p1fn", parent1_family_name);
        b.putString("p1gn", parent1_given_name);
        b.putString("p1phn", parent1_contact);
        b.putString("p2fn", parent2_family_name);
        b.putString("p2gn", parent2_given_name);
        b.putString("p2phn", parent2_contact);
        b.putString("dor", dist_origin);
        b.putString("subc", sub_county);
        b.putString("vlln", village_name);
        b.putString("cstate", current_state);
        b.putString("doreason", dropout_reason);
        b.putString("nts", notes);



        return b;
    }


}
