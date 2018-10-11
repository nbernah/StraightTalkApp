package com.example.netlabs.straighttalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List_View extends AppCompatActivity {
    //Toolbar toolbar;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view);
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle(getResources().getString(R.string.app_name));
        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(List_View.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.institutions));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               // Intent intent = new Intent(List_View.this, PERSONAL_DETAILS.class);
               // intent.putExtra("institutename", intent.toString());
               // startActivity(intent);

                if (i==0) {
                    Intent intent = new Intent(List_View.this, ViewPersonalDetailsActivity.class);
                    startActivity(intent);
                }
                else if (i==1) {
                    Intent intent = new Intent(List_View.this, PERSONAL_DETAILS.class);
                    startActivity(intent);
                }
                else if (i==2) {
                    Intent intent = new Intent(List_View.this, ViewSecondaryActivity.class);
                    startActivity(intent);
                }
                else if (i==3) {
                    Intent intent = new Intent(List_View.this, SECONDARY.class);
                    startActivity(intent);
                }
                else if (i==4) {
                    Intent intent = new Intent(List_View.this, ViewInstitutionActivity.class);
                    startActivity(intent);
                }
                else if (i==5) {
                    Intent intent = new Intent(List_View.this, INSTITUTIONS.class);
                    startActivity(intent);
                }

                }

        });
        listView.setAdapter(mAdapter);


    }
}
