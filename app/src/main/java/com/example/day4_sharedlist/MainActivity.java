package com.example.day4_sharedlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner empStatus;
    private String[] empStatusList;
    private ArrayAdapter<String> empAdapter;

    private Spinner empDes;
    private String[] empDesList;
    private ArrayAdapter<String> empDesAdapter;

    private Button btnLoc;

    private Spinner issue;
    private String[] issueList;
    private ArrayAdapter<String> issueAdapter;

    private RadioGroup title;

    private EditText fName;
    private EditText lName;
    private EditText email;
    private EditText country;
    private EditText date;
    private EditText desc;

    private RatingBar rate;

    private Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actBar =getSupportActionBar();
        actBar.setTitle("Complaint Form");

        title = findViewById(R.id.radioGroup);
        fName = findViewById(R.id.editText);
        lName = findViewById(R.id.editText2);
        email = findViewById(R.id.editText6);
        country = findViewById(R.id.editText7);
        date = findViewById(R.id.editText8);
        rate = findViewById(R.id.ratingBar);
        desc = findViewById(R.id.editText9);
        btnsubmit = findViewById(R.id.button3);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sint= new Intent(MainActivity.this, ComplaintSummaryActivity.class);
                startActivity(sint);
            }
        });

        empStatus = findViewById(R.id.spinner1);
        empStatusList = new String[]{
                "Full Time", "Part Time", "Trainee"
        };
        empAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, empStatusList);
        empStatus.setAdapter(empAdapter);
        empStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String empStat = empStatusList[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        empDes = findViewById(R.id.spinner2);
        empDesList = new String[]{
                    "Software Engineer", "Sr.Software Engineer", "Project Manager", "Support Engineer", "Designer", "Marketing", "etc"
        };
        empDesAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, empDesList);
        empDes.setAdapter(empDesAdapter);
        empDes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String empD = empDesList[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnLoc= findViewById(R.id.button1);
        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mint= new Intent(MainActivity.this, LocationActivity.class);
                startActivity(mint);
            }
        });

        issue = findViewById(R.id.spinner3);
        issueList = new String[]{
                "Network Problem", "System Crashing", "Slow Internet", "Software Installation", "etc"
        };
        issueAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, issueList);
        issue.setAdapter(issueAdapter);
        issue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String issue1 = issueList[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
