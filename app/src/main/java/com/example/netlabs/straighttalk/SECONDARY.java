package com.example.netlabs.straighttalk;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
import com.example.netlabs.straighttalk.model.database.BursaryRepository;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetails;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;
import com.example.netlabs.straighttalk.viewmodel.PersonalDetailsViewModel;
import com.example.netlabs.straighttalk.viewmodel.SecondaryViewModel;

import java.util.HashMap;
import java.util.Map;

public class SECONDARY extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextSchool_name;
    private EditText editTextSchool_form;
    private EditText editTextForm_stream;
    private EditText editTextStudent_index_number;


    private Button btn_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        editTextSchool_name = findViewById(R.id.SS_name);
        editTextSchool_form = findViewById(R.id.SS_form);
        editTextForm_stream = findViewById(R.id.SS_stream);
        editTextStudent_index_number = findViewById(R.id.Student_index_number);


        btn_submit = findViewById(R.id.submit_btn);

        //associate UI to ViewModel
//        SecondaryViewModel secondaryViewModel = ViewModelProviders.of(this).get(SecondaryViewModel.class);
//        PersonalDetailsViewModel personalDetailsViewModel
//                = ViewModelProviders.of(this).get(PersonalDetailsViewModel.class);
        btn_submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == btn_submit)
           // buttonSubmit();
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



        final String ss_name = editTextSchool_name.getText().toString().trim();
        final String ss_form = editTextSchool_form.getText().toString().trim();
        final String ss_stream = editTextForm_stream.getText().toString().trim();
        final String student_index_number = editTextStudent_index_number.getText().toString().trim();



//        Secondary details = new Secondary();
//        details.setStfId(Integer.parseInt(stf_id));
//        //details.setSsName(ss_name);
//        details.setSsForm(Integer.parseInt(ss_form));
//        details.setSsStream(ss_stream);
//        details.setFavSubject(fav_subject);
//        details.setFavSport(fav_sport);
//        details.setStudentId(student_id);
//        details.setExamDate(exam_date);
//        details.setBursaryFunder(bursary_funder);
//        details.setBursaryDate(bursary_date);
//        details.setBursaryYoStart(bursary_yo_start);
//        details.setCurrentClass(current_class);
//        details.setClassCompletionSS(class_completion_ss);
//        details.setCompletionSS(completion_ss);
//
//
//        BursaryRepository viewModel = null;
//        viewModel.insertSecondary(details);

    }


}
