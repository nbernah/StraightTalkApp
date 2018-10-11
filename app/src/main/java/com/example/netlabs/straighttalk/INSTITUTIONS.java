package com.example.netlabs.straighttalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class INSTITUTIONS extends AppCompatActivity implements View.OnClickListener{
    private EditText editTextInstitution_name;
    private EditText editTextCourse_name;
    private EditText editTextInstitution_student_id;
    private EditText editTextRegistration_number;
    private EditText editTextHostel_name;
    private EditText editTextQualification;
    private EditText editTextBank;
    private EditText editTextBank_address;
    private EditText editTextAccount_number;




    private Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institutions);

        editTextInstitution_name = findViewById(R.id.College_name);
        editTextCourse_name = findViewById(R.id.Uni_course);
        editTextInstitution_student_id = findViewById(R.id.Student_number);
        editTextRegistration_number = findViewById(R.id.Registration_number);
        editTextHostel_name = findViewById(R.id.Accomodation);
        editTextQualification = findViewById(R.id.Award_level);
        editTextBank = findViewById(R.id.Bank);
        editTextBank_address = findViewById(R.id.Bank_addr);
        editTextAccount_number = findViewById(R.id.Account_number);
        btn_submit = findViewById(R.id.submit_btn);

        btn_submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == btn_submit)
            //buttonSubmit();
        finish();
    }

    private void buttonSubmit() {
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String sfn = b.getString("sft", "name");
        String sgn = b.getString("sgn", "name");
        String dob = b.getString("dob", "date");
        String gender = b.getString("gender", "gender");
        String sch = b.getString("sch", "school");
        String ethn = b.getString("ethn", "ethnicity");
        String entgrd = b.getString("entgrd", "grade");
        String nId = b.getString("nId", "id");
        String regyr = b.getString("regyr", "year");
        String stdhn = b.getString("stdhn", "phone");
        String ctmail = b.getString("ctmail", "email");
        String yos = b.getString("yos", "year");
        String yoe = b.getString("yoe", "year");
        String uce = b.getString("uce", "grade");
        String uace = b.getString("uace", "grade");
        String p1fn = b.getString("p1fn", "name");
        String p1gn = b.getString("p1gn", "name");
        String p1phn = b.getString("p1phn", "phone");
        String p2fn = b.getString("p2fn", "name");
        String p2gn = b.getString("p2gn", "name");
        String p2phn = b.getString("p2phn", "phone");
        String dor = b.getString("dor", "district");
        String subc = b.getString("subc", "scounty");
        String vlln = b.getString("vlln", "name");
        String cstate = b.getString("cstate", "currentstate");
        String doreason = b.getString("doreason", "reason");
        String nts = b.getString("nts", "notes");

        final String institution_name = editTextInstitution_name.getText().toString().trim();
        final String course_name = editTextCourse_name.toString().trim();
        final String institution_student_id= editTextInstitution_student_id.toString().trim();
        final String registration_number = editTextRegistration_number.getText().toString().trim();
        final String hostel_name = editTextHostel_name.toString().trim();
        final String qualification = editTextQualification.toString().trim();
        final String bank = editTextBank.getText().toString().trim();
        final String bank_address = editTextBank_address.getText().toString().trim();
        final String account_number = editTextAccount_number.getText().toString().trim();

//        Institutions details = new Institutions();
//        details.setStfId(Integer.parseInt(stf_id));
//        //details.setSsName(ss_name);
//        details.setStfId(Integer.parseInt(stf_id));
//        //details.setCollegeName(college_name);
//        //details.setUni_course(uni_course);
//        details.setStudentNumber(Integer.parseInt(student_number));
//        details.setRegistrationNumber(registration_number);
//        //details.setAccomodation(accomodation);
//        details.setUniYos(uni_yos);
//        details.setUniYoc(uni_yoc);
//        //details.setUniAwardLevel(uni_award_level);
//
//
//        BursaryRepository viewModel = null;
//        viewModel.insertInstitution(details);

    }
    }


    //@Override

//    public void startNext(View v) {
//        if (v == buttonLogin)
//            Login();
//        //if (v == buttonsubmit)
//        startActivity(new Intent(this, PERSONAL_DETAILS.class));
//    }


