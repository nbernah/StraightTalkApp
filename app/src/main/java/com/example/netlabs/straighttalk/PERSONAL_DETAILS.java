package com.example.netlabs.straighttalk;

import android.arch.lifecycle.ViewModelProviders;
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
import com.example.netlabs.straighttalk.model.database.entities.Student;
import com.example.netlabs.straighttalk.viewmodel.PersonalDetailsViewModel;

import java.util.HashMap;
import java.util.Map;

public class PERSONAL_DETAILS extends AppCompatActivity implements View.OnClickListener{
    private static final String SUBMIT_URL = "http://localhost/phpmyadmin/sql.php?server=1&db=stalk&table=users&pos=0&token=" + MyConfig.TOKEN;
    private static final String KEY_STF_ID = "stf_id";
    private static final String KEY_STUD_FAMILY_NAME = "stud_family_name";
    private static final String KEY_STUD_GIVEN_NAME = "stud_family_name";
    private static final String KEY_DOB = "dob";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_ETHNICITY = "ethnicity";
    private static final String KEY_ENTRY_AGGRTS = "entry_aggrts";
    private static final String KEY_HEALTH_STATUS = "health_status";
    private static final String KEY_STUD_CONTACT_PHONE = "stud_contact_phone";
    private static final String KEY_STUD_CONTACT_EMAIL = "stud_contact_email";
    private static final String KEY_PARENT1_FAMILY_NAME = "parent1_family_name";
    private static final String KEY_PARENT1_GIVEN_NAME = "parent1_given_name";
    private static final String KEY_PARENT1_CONTACT = "parent1_contact";
    private static final String KEY_PARENT2_FAMILY_NAME = "parent2_family_name";
    private static final String KEY_PARENT2_GIVEN_NAME = "parent2_given_name";
    private static final String KEY_PARENT2_CONTACT = "parent2_contact";
    private static final String KEY_DIST_ORIGIN = "dist_origin";
    private static final String KEY_SUB_COUNTY = "sub_county";
    private static final String KEY_VILLAGE_NAME = "village_name";
    private static final String KEY_BANK = "bank";
    private static final String KEY_BANK_ADDR = "bank_addr";
    private static final String KEY_ACCOUNT_NUMBER = "account_number";
    private static final String KEY_CURRENT_STATE = "current_state";
    private static final String KEY_DROPOUT_REASON = "dropout_reason";
    private static final String KEY_NOTES = "notes";

    private EditText editTextStf_id;
    private EditText editTextStud_family_name;
    private EditText editTextStud_given_name;
    private EditText editTextDob;
    private Spinner spinnerGender;
    private EditText editTextEthnicity;
    private EditText editTextEntry_aggrts;
    private EditText editTextHealth_status;
    private EditText editTextStud_contact_phone;
    private EditText editTextStud_contact_email;
    private EditText editTextParent1_family_name;
    private EditText editTextParent1_given_name;
    private EditText editTextParent1_contact;
    private EditText editTextParent2_family_name;
    private EditText editTextParent2_given_name;
    private EditText editTextParent2_contact;
    private Spinner spinnerDist_origin;
    private Spinner spinnerSub_county;
    private EditText editTextVillage_name;
    private EditText editTextBank;
    private EditText editTextBank_addr;
    private EditText editTextAccount_number;
    private EditText editTextCurrent_state;
    private EditText editTextDropout_reason;
    private EditText editTextNotes;


    private Button btn_submit;
    private Button buttonsubmit;


    private PersonalDetailsViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__details);

        editTextStf_id = findViewById(R.id.Stf_id);
        editTextStud_family_name = findViewById(R.id.Stud_family_name);
        editTextStud_given_name = findViewById(R.id.Stud_given_name);
        editTextDob = findViewById(R.id.Dob);
        spinnerGender = findViewById(R.id.Gender);
        editTextEthnicity = findViewById(R.id.Ethnicity);
        editTextEntry_aggrts = findViewById(R.id.Entry_aggrts);
        editTextHealth_status = findViewById(R.id.Health_status);
        editTextStud_contact_phone = findViewById(R.id.Stud_contact_phone);
        editTextStud_contact_email = findViewById(R.id.Stud_contact_email);
        editTextParent1_family_name = findViewById(R.id.parent1_family_name);
        editTextParent1_given_name = findViewById(R.id.Parent1_given_name);
        editTextParent1_contact = findViewById(R.id.Parent1_contact);
        editTextParent2_family_name = findViewById(R.id.parent2_family_name);
        editTextParent2_given_name = findViewById(R.id.Parent2_given_name);
        editTextParent2_contact = findViewById(R.id.Parent2_contact);
        spinnerDist_origin = findViewById(R.id.Dist_origin);
        spinnerSub_county = findViewById(R.id.Sub_county);
        editTextVillage_name = findViewById(R.id.Village_name);
        editTextBank = findViewById(R.id.Bank);
        editTextBank_addr = findViewById(R.id.Bank_addr);
        editTextAccount_number = findViewById(R.id.Account_number);
        editTextCurrent_state = findViewById(R.id.Current_state);
        editTextDropout_reason = findViewById(R.id.Dropout_reason);
        editTextNotes = findViewById(R.id.Notes);

        //associate UI to ViewModel
        viewModel = ViewModelProviders.of(this).get(PersonalDetailsViewModel.class);

        btn_submit = findViewById(R.id.submit_btn);
        btn_submit.setOnClickListener(this);
    }

    private void Submit() {

        final String stf_id = editTextStf_id.getText().toString().trim();
        final String stud_family_name = editTextStud_family_name.getText().toString().trim();
        final String stud_given_name = editTextStud_given_name.getText().toString().trim();
        final String dob = editTextDob.getText().toString().trim();
        final String gender = spinnerGender.toString().trim();
        final String ethnicity = editTextEthnicity.getText().toString().trim();
        final String entry_aggrts = editTextEntry_aggrts.getText().toString().trim();
        final String health_status = editTextHealth_status.getText().toString().trim();
        final String stud_contact_phone = editTextStud_contact_phone.getText().toString().trim();
        final String stud_contact_email = editTextStud_contact_email.getText().toString().trim();
        final String parent1_family_name = editTextParent1_family_name.getText().toString().trim();
        final String parent1_given_name = editTextParent1_given_name.getText().toString().trim();
        final String parent1_contact = editTextParent1_contact.getText().toString().trim();
        final String parent2_family_name = editTextParent2_family_name.getText().toString().trim();
        final String parent2_given_name = editTextParent2_given_name.getText().toString().trim();
        final String parent2_contact = editTextParent2_contact.getText().toString().trim();
        final String dist_origin = spinnerDist_origin.toString().trim();
        final String sub_county = spinnerSub_county.toString().trim();
        final String village_name = editTextVillage_name.getText().toString().trim();
        final String bank = editTextBank.getText().toString().trim();
        final String bank_addr = editTextBank_addr.getText().toString().trim();
        final String account_number = editTextAccount_number.getText().toString().trim();
        final String current_state = editTextCurrent_state.getText().toString().trim();
        final String dropout_reason = editTextDropout_reason.getText().toString().trim();
        final String notes = editTextNotes.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, SUBMIT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String Response) {
                        Toast.makeText(PERSONAL_DETAILS.this, "response", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PERSONAL_DETAILS.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_STF_ID, stf_id);
                params.put(KEY_STUD_FAMILY_NAME, stud_family_name);
                params.put(KEY_STUD_GIVEN_NAME, stud_given_name);
                params.put(KEY_DOB, dob);
                params.put(KEY_GENDER, gender);
                params.put(KEY_ETHNICITY, ethnicity);
                params.put(KEY_ENTRY_AGGRTS, entry_aggrts);
                params.put(KEY_HEALTH_STATUS, health_status);
                params.put(KEY_STUD_CONTACT_PHONE, stud_contact_phone);
                params.put(KEY_STUD_CONTACT_EMAIL, stud_contact_email);
                params.put(KEY_PARENT1_FAMILY_NAME, parent1_family_name);
                params.put(KEY_PARENT1_GIVEN_NAME, parent1_given_name);
                params.put(KEY_PARENT1_CONTACT, parent1_contact);
                params.put(KEY_PARENT2_FAMILY_NAME, parent2_family_name);
                params.put(KEY_PARENT2_GIVEN_NAME, parent2_given_name);
                params.put(KEY_PARENT2_CONTACT, parent2_contact);
                params.put(KEY_DIST_ORIGIN, dist_origin);
                params.put(KEY_SUB_COUNTY, sub_county);
                params.put(KEY_VILLAGE_NAME, village_name);
                params.put(KEY_BANK, bank);
                params.put(KEY_BANK_ADDR, bank_addr);
                params.put(KEY_ACCOUNT_NUMBER, account_number);
                params.put(KEY_CURRENT_STATE, current_state);
                params.put(KEY_DROPOUT_REASON, dropout_reason);
                params.put(KEY_NOTES, notes);
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
            buttonSubmit();
        startActivity(new Intent(this, List_View.class));
    }

    private void buttonSubmit() {
        final String stf_id = editTextStf_id.getText().toString().trim();
        final String stud_family_name = editTextStud_family_name.getText().toString().trim();
        final String stud_given_name = editTextStud_given_name.getText().toString().trim();
        final String dob = editTextDob.getText().toString().trim();
        final String gender = spinnerGender.toString().trim();
        final String ethnicity = editTextEthnicity.getText().toString().trim();
        final String entry_aggrts = editTextEntry_aggrts.getText().toString().trim();
        final String health_status = editTextHealth_status.getText().toString().trim();
        final String stud_contact_phone = editTextStud_contact_phone.getText().toString().trim();
        final String stud_contact_email = editTextStud_contact_email.getText().toString().trim();
        final String parent1_family_name = editTextParent1_family_name.getText().toString().trim();
        final String parent1_given_name = editTextParent1_given_name.getText().toString().trim();
        final String parent1_contact = editTextParent1_contact.getText().toString().trim();
        final String parent2_family_name = editTextParent2_family_name.getText().toString().trim();
        final String parent2_given_name = editTextParent2_given_name.getText().toString().trim();
        final String parent2_contact = editTextParent2_contact.getText().toString().trim();
        final String dist_origin = "kla"; // spinnerDist_origin.toString().trim();
        final String sub_county = "rubaga"; // spinnerSub_county.toString().trim();
        final String village_name = editTextVillage_name.getText().toString().trim();
        final String bank = editTextBank.getText().toString().trim();
        final String bank_addr = editTextBank_addr.getText().toString().trim();
        final String account_number = editTextAccount_number.getText().toString().trim();
        final String current_state = editTextCurrent_state.getText().toString().trim();
        final String dropout_reason = editTextDropout_reason.getText().toString().trim();
        final String notes = editTextNotes.getText().toString().trim();

//        Student details = new Student();
//        details.setStfId(Integer.parseInt(stf_id));
//        details.setStudFamilyName(stud_family_name);
//        details.setStudGivenName(stud_given_name);
//        details.setDob(dob);
//        details.setGender(gender);
//        details.setEthnicity(ethnicity);
//        details.setEntryAggrts(Integer.parseInt(entry_aggrts));
//        details.setHealthStatus(health_status);
//        details.setStudContactPhone(Integer.parseInt(stud_contact_phone));
//        details.setStudContactEmail(stud_contact_email);
//        details.setParent1FamilyName(parent1_family_name);
//        details.setParent1GivenName(parent1_given_name);
//        details.setParent1Contact(Integer.parseInt(parent1_contact));
//        details.setParent2FamilyName(parent2_family_name);
//        details.setParent2GivenName(parent2_given_name);
//        details.setParent2Contact(Integer.parseInt(parent2_contact));
//        details.setVillageName(village_name);
//        details.setBank(bank);
//        details.setBankAddr(bank_addr);
//        details.setAccountNumber(account_number);
//        details.setCurrentState(current_state);
//        details.setDropOutReason(dropout_reason);
//        details.setNotes(notes);

//        viewModel.insertPersonalDetails(details);
    }

}
