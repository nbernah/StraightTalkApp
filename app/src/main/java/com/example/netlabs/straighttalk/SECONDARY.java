package com.example.netlabs.straighttalk;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
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
    private static final String SUBMIT_URL = "http://localhost/phpmyadmin/sql.php?server=1&db=stalk&table=users&pos=0&token=" + MyConfig.TOKEN;
    private static final String KEY_STF_ID = "stf_id";
    private static final String TAG = "SECONDARY";
    private static final String KEY_SS_NAME = "ss_name";
    private static final String KEY_SS_FORM = "ss_form";
    private static final String KEY_SS_STREAM = "ss_stream";
    private static final String KEY_SUBJECT_LIST = "subject_list";
    private static final String KEY_FAV_SUBJECT = "fav_subject";
    private static final String KEY_FAV_SPORT = "fav_sport";
    private static final String KEY_SCHOOL_CODE = "school_code";
    private static final String KEY_STUDENT_ID = "student_id";
    private static final String KEY_EXAM_DATE = "exam_date";
    private static final String KEY_BURSARY_FUNDER = "bursary_funder";
    private static final String KEY_BURSARY_DATE = "bursary_date";
    private static final String KEY_BURSARY_YO_START = "bursary_yo_start";
    private static final String KEY_CURRENT_CLASS = "current_class";
    private static final String KEY_CLASS_COPMLETION_SS = "class_completion_ss";
    private static final String KEY_COMPLETION_SS = "completion_ss";


    private EditText editTextStf_id;
    private EditText editTextSs_name;
    private EditText editTextSs_form;
    private EditText editTextSs_stream;
    private Spinner spinnerSubject_list;
    private EditText editTextFav_subject;
    private EditText editTextFav_sport;
    private Spinner spinnerSchool_code;
    private EditText editTextStudent_id;
    private EditText editTextExam_date;
    private EditText editTextBursary_funder;
    private EditText editTextBursary_date;
    private EditText editTextBursary_yo_start;
    private EditText editTextCurrent_class;
    private EditText editTextClass_completion_ss;
    private EditText editTextCompletion_ss;


    private Button btn_submit;
    private Button buttonsubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        editTextStf_id = findViewById(R.id.Stf_id);
        editTextSs_name = findViewById(R.id.SS_name);
        editTextSs_form = findViewById(R.id.SS_form);
        editTextSs_stream = findViewById(R.id.SS_stream);
        spinnerSubject_list = findViewById(R.id.Subject_list);
        editTextFav_subject = findViewById(R.id.Fav_subect);
        editTextFav_sport = findViewById(R.id.Fav_sport);
        spinnerSchool_code = findViewById(R.id.School_code);
        editTextStudent_id = findViewById(R.id.Student_id);
        editTextExam_date = findViewById(R.id.Exam_date);
        editTextBursary_funder = findViewById(R.id.Bursary_funder);
        editTextBursary_date = findViewById(R.id.Bursary_date);
        editTextBursary_yo_start = findViewById(R.id.Bursary_yo_start);
        editTextCurrent_class = findViewById(R.id.Current_class);
        editTextClass_completion_ss = findViewById(R.id.Class_completion_ss);
        editTextCompletion_ss = findViewById(R.id.Completion_ss);
        btn_submit = findViewById(R.id.submit_btn);

        //associate UI to ViewModel
        SecondaryViewModel viewModel = ViewModelProviders.of(this).get(SecondaryViewModel.class);

        btn_submit.setOnClickListener(this);
    }

    private void Submit() {

        final String stf_id = editTextStf_id.getText().toString().trim();
        //final String ss_name = editTextSs_name.getText().toString().trim();
        final String ss_form = editTextSs_form.getText().toString().trim();
        final char ss_stream = editTextSs_stream.getText().toString().trim().toCharArray()[0];
        final String subect_list = spinnerSubject_list.toString().trim();
        final String fav_subject = editTextFav_subject.getText().toString().trim();
        final String fav_sport = editTextFav_sport.getText().toString().trim();
        final String school_code = spinnerSchool_code.toString().trim();
        final String student_id = editTextStudent_id.getText().toString().trim();
        final String exam_date = editTextExam_date.getText().toString().trim();
        final String bursary_funder = editTextBursary_funder.getText().toString().trim();
        final String bursary_date = editTextBursary_date.getText().toString().trim();
        final String bursary_yo_start = editTextBursary_yo_start.getText().toString().trim();
        final String current_class = editTextCurrent_class.getText().toString().trim();
        final String class_completion_ss = editTextClass_completion_ss.getText().toString().trim();
        final String completion_ss = editTextCompletion_ss.getText().toString().trim();



        Secondary details = new Secondary();
        details.setStfId(Integer.parseInt(stf_id));
        //details.setSsName(ss_name);
        details.setSsForm(Integer.parseInt(ss_form));
        details.setSsStream(ss_stream);
        details.setFavSubject(fav_subject);
        details.setFavSport(fav_sport);
        details.setStudentId(student_id);
        details.setExamDate(exam_date);
        details.setBursaryFunder(bursary_funder);
        details.setBursaryDate(bursary_date);
        details.setBursaryYoStart(bursary_yo_start);
        details.setCurrentClass(current_class);
        details.setClassCompletionSS(class_completion_ss);
        details.setCompletionSS(completion_ss);


        BursaryRepository viewModel = null;
        viewModel.insertSecondary(details);

    }

    @Override
    public void onClick(View v) {

    }
}
