package com.example.netlabs.straighttalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOGIN_URL = "http://localhost/phpmyadmin/sql.php?server=1&db=stalk&table=users&pos=0&token=" + MyConfig.TOKEN;

    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private EditText editTextEmail;
    private EditText editTextPassword;


    private Button buttonLogin;
    private Button buttonsubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextemail);
        editTextPassword = findViewById(R.id.editTextpassword);
        buttonLogin = findViewById(R.id.buttonlogin);

        buttonLogin.setOnClickListener(this);
    }

    private void Login() {

        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String Response) {
                        Toast.makeText(MainActivity.this, "response", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_EMAIL, email);
                params.put(KEY_PASSWORD, password);
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
        if (view == buttonLogin)
            Login();
        startActivity(new Intent(this, List_View.class));
    }
}
