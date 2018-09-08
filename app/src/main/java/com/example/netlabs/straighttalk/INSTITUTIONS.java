package com.example.netlabs.straighttalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.HashMap;
import java.util.Map;

public class INSTITUTIONS extends AppCompatActivity implements View.OnClickListener{
    private static final String SUBMIT_URL = "http://localhost/phpmyadmin/sql.php?server=1&db=stalk&table=users&pos=0&token=" + MyConfig.TOKEN;
    private static final String KEY_STF_ID = "stf_id";
    private static final String KEY_COLLEGE_NAME ="college_name";
    private static final String KEY_UNI_COURSE = "uni_course";
    private static final String KEY_STUDENT_NUMBER = "student_number";
    private static final String KEY_REGISTRATON_NUMBER = "registration_number";
    private static final String KEY_ACCOMODATION = "accomodation";
    private static final String KEY_UNI_YOS = "uni_yos";
    private static final String KEY_UNI_YOC = "uni_yoc";
    private static final String KEY_UNI_AWARD_LEVEL = "uni_award_level";


    private EditText editTextStf_id;
    private Spinner spinnerCollege_name;
    private Spinner spinnerUni_course;
    private EditText editTextStudent_number;
    private EditText editTextRegistration_number;
    private Spinner spinnerAccomodation;
    private EditText editTextUni_yos;
    private EditText editTextUni_yoc;
    private EditText editTextUni_award_level;




    private Button btn_submit;
    private Button buttonsubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institutions);

        editTextStf_id = findViewById(R.id.Stf_id);
        spinnerCollege_name = findViewById(R.id.COLLEGE_NAME);
        spinnerUni_course = findViewById(R.id.UNI_COURSE);
        editTextStudent_number = findViewById(R.id.STUDENT_NUMBER);
        editTextRegistration_number = findViewById(R.id.REGISTRATION_NUMBER);
        spinnerAccomodation = findViewById(R.id.ACCOMODATION);
        editTextUni_yos = findViewById(R.id.UNI_YOS);
        editTextUni_yoc = findViewById(R.id.UNI_YOC);
        editTextUni_award_level = findViewById(R.id.UNI_AWARD_LEVEL);
        btn_submit = findViewById(R.id.submit_btn);

        btn_submit.setOnClickListener(this);
    }

    private void Submit() {

        final String stf_id = editTextStf_id.getText().toString().trim();
        final String college_name = spinnerCollege_name.toString().trim();
        final String uni_course = spinnerUni_course.toString().trim();
        final String student_number = editTextStudent_number.getText().toString().trim();
        final String registration_number = editTextRegistration_number.getText().toString().trim();
        final String accomodation = spinnerAccomodation.toString().trim();
        final String uni_yos = editTextUni_yos.toString().trim();
        final String uni_yoc = editTextUni_yoc.getText().toString().trim();
        final String uni_award_level = editTextUni_award_level.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, SUBMIT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String Response) {
                        Toast.makeText(INSTITUTIONS.this, "response", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(INSTITUTIONS.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_STF_ID, stf_id);
                params.put(KEY_COLLEGE_NAME, college_name);
                params.put(KEY_UNI_COURSE, uni_course);
                params.put(KEY_STUDENT_NUMBER, student_number);
                params.put(KEY_REGISTRATON_NUMBER, registration_number);
                params.put(KEY_ACCOMODATION, accomodation);
                params.put(KEY_UNI_YOS, uni_yos);
                params.put(KEY_UNI_YOC, uni_yoc);
                params.put(KEY_UNI_AWARD_LEVEL, uni_award_level);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    //@Override

//    public void startNext(View v) {
//        if (v == buttonLogin)
//            Login();
//        //if (v == buttonsubmit)
//        startActivity(new Intent(this, PERSONAL_DETAILS.class));
//    }

    @Override
    public void onClick(View view) {
        if (view == btn_submit)
            buttonsubmit();
        startActivity(new Intent(this, List_View.class));
    }

    private void buttonsubmit() {
    }
}
