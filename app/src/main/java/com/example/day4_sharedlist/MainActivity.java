package com.example.day4_sharedlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.day4_sharedlist.Modal.Complaint;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rTitle;
    private EditText edtFName;
    private EditText edtLName;
    private Spinner empStatus;
    private String[] empStatusList;
    private ArrayAdapter<String> empAdapter;
    private Spinner empDes;
    private String[] empDesList;
    private ArrayAdapter<String> empDesAdapter;
    private Button btnLoc;
    private EditText edtEmail;
    private EditText edtCountry;
    private EditText edtDate;
    private Spinner sIssue;
    private String[] issueList;
    private ArrayAdapter<String> issueAdapter;
    private RatingBar rbRate;
    private EditText edtDesc;
    private Button btnSubmit;
    private Button btnClear;
    private String rgtitle;
    private String empStat;
    private String empD;
    private String issue1;
    private String rbrating;

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("spref", MODE_PRIVATE);

        ActionBar actBar =getSupportActionBar();
        actBar.setTitle("Complaint Form");

        // Radio Group
        rTitle = findViewById(R.id.radioGroup);
        rTitle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        rgtitle = "Mr.";
                        Toast.makeText(MainActivity.this, rgtitle, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        rgtitle = "Mrs.";
                        Toast.makeText(MainActivity.this, rgtitle, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3:
                        rgtitle = "Ms.";
                        Toast.makeText(MainActivity.this, rgtitle, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton4:
                        rgtitle = "Miss";
                        Toast.makeText(MainActivity.this, rgtitle, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton5:
                        rgtitle = "Dr.";
                        Toast.makeText(MainActivity.this, rgtitle, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton6:
                        rgtitle= "Sir";
                        Toast.makeText(MainActivity.this, rgtitle, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton7:
                        rgtitle = "Lord";
                        Toast.makeText(MainActivity.this, rgtitle, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        // First and Last Name
        edtFName = findViewById(R.id.editText);
        edtLName = findViewById(R.id.editText2);

        // Emp status
        empStatus = findViewById(R.id.spinner1);
        empStatusList = new String[]{
                "Full Time", "Part Time", "Trainee"
        };
        empAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, empStatusList);
        empStatus.setAdapter(empAdapter);
        empStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                empStat = empStatusList[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Designation
        empDes = findViewById(R.id.spinner2);
        empDesList = new String[]{
                "Software Engineer", "Sr.Software Engineer", "Project Manager", "Support Engineer", "Designer", "Marketing", "etc"
        };
        empDesAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, empDesList);
        empDes.setAdapter(empDesAdapter);
        empDes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                empD = empDesList[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Location
        btnLoc= findViewById(R.id.button1);
        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor ed = pref.edit();
                Intent mint= new Intent(MainActivity.this, LocationActivity.class);
                startActivity(mint);
            }
        });

        // Location from location.java
        final Intent rInt = getIntent();
        final String a = rInt.getStringExtra("street");
        final String b = rInt.getStringExtra("city");
        final String c = rInt.getStringExtra("postal");

        // Email, Country and date
        edtEmail = findViewById(R.id.editText6);
        edtCountry = findViewById(R.id.editText7);
        edtDate = findViewById(R.id.editText8);

        //Issue type
        sIssue = findViewById(R.id.spinner3);
        issueList = new String[]{
                "Network Problem", "System Crashing", "Slow Internet", "Software Installation", "etc"
        };
        issueAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, issueList);
        sIssue.setAdapter(issueAdapter);
        sIssue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                issue1 = issueList[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Rating Bar
        rbRate = findViewById(R.id.ratingBar);
        rbRate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rbrating = String.valueOf(rating);
                Toast.makeText(MainActivity.this, String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });

        //Description
        edtDesc = findViewById(R.id.editText9);

        //Submit Button
        btnSubmit = findViewById(R.id.button3);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = edtFName.getText().toString().trim();
                String lname = edtLName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String country = edtCountry.getText().toString().trim();
                String date = edtDate.getText().toString().trim();
                String desc = edtDesc.getText().toString().trim();
                String d = (a + " " + b + " " + c);

                if (fname.isEmpty()) {
                    edtFName.setError("Please enter First Name");
                } else if (lname.isEmpty()) {
                    edtLName.setError("Please enter Last Name");
                } else if (email.isEmpty()) {
                    edtEmail.setError("Please enter Email");
                } else if (country.isEmpty()){
                    edtCountry.setError("Please enter country code/ cell phone number");
                }else if(date.isEmpty()){
                    edtDate.setError("Please enter a date");
                } else if(desc.isEmpty()){
                    edtDesc.setError("Please enter description");
                }else {

                    Complaint tempObj = new Complaint(rgtitle, fname, lname, empStat, empD, d, email, country,
                            date, issue1, rbrating, desc);

                    Intent sint = new Intent(MainActivity.this, ComplaintSummaryActivity.class);
                    sint.putExtra("complainObj",tempObj);
                    startActivity(sint);
                }
            }
        });

        //Clear Button
        btnClear = findViewById(R.id.button4);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtFName.setText("");
                edtLName.setText("");
                edtEmail.setText("");
                edtCountry.setText("");
                edtDate.setText("");
                edtDesc.setText("");
                rTitle.clearCheck();   // https://stackoverflow.com/questions/10497921/uncheck-all-radiobutton-in-a-radiobuttongroup
                rbRate.setRating(0F);  // https://stackoverflow.com/questions/27565455/how-to-clear-rate-of-ratingbar-in-android
            }
        });
    }
}
