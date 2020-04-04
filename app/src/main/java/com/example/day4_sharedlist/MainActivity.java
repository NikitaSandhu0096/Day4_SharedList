package com.example.day4_sharedlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
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

    private RadioGroup rtitle;

    private EditText edtfName;
    private EditText edtlName;
    private EditText edtemail;
    private EditText edtcountry;
    private EditText edtdate;
    private EditText edtdesc;

    private RatingBar rbrate;

    private Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actBar =getSupportActionBar();
        actBar.setTitle("Complaint Form");

        final Intent rInt = getIntent();
        final String a = rInt.getStringExtra("street");
        final String b = rInt.getStringExtra("city");
        final String c = rInt.getStringExtra("postal");

        rtitle = findViewById(R.id.radioGroup);

        rtitle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String rgtitle = "";
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

        edtfName = findViewById(R.id.editText);
        edtlName = findViewById(R.id.editText2);
        edtemail = findViewById(R.id.editText6);
        edtcountry = findViewById(R.id.editText7);
        edtdate = findViewById(R.id.editText8);

        rbrate = findViewById(R.id.ratingBar);
        rbrate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String rbrating = String.valueOf(rating);
                Toast.makeText(MainActivity.this, String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });

        edtdesc = findViewById(R.id.editText9);

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

        btnsubmit = findViewById(R.id.button3);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = edtfName.getText().toString().trim();
                String lname = edtlName.getText().toString().trim();
                String email = edtemail.getText().toString().trim();
                String country = edtcountry.getText().toString().trim();
                String date = edtdate.getText().toString().trim();
                String desc = edtdesc.getText().toString().trim();

                if (fname.isEmpty()) {
                    edtfName.setError("Please enter First Name");
                } else if (lname.isEmpty()) {
                    edtlName.setError("Please enter Last Name");
                } else if (email.isEmpty()) {
                    edtemail.setError("Please enter Email");
                } else if (country.isEmpty()){
                    edtcountry.setError("Please enter country code/ cell phone number");
                }else if(date.isEmpty()){
                    edtdate.setError("Please enter a date");
                } else if(desc.isEmpty()){
                    edtdesc.setError("Please enter description");
                }else {
                   // Complaint tempObj = new Complaint();


                   // AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                   // alert.setCancelable(false);
                   // alert.setTitle("Are you sure you want to send data back?");
                   // alert.setMessage("Upper Cased : "+ a + b + c);
                   // alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   //     @Override
                   //     public void onClick(DialogInterface dialog, int which) {
                     //       dialog.dismiss();
                       // }
                   // });
                    //alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                      //  @Override
                        //public void onClick(DialogInterface dialog, int which) {
                         //   dialog.cancel();
                       // }
                   // });
                    //AlertDialog aDialog = alert.create();
                    //aDialog.show();
                    Intent sint = new Intent(MainActivity.this, ComplaintSummaryActivity.class);

                    startActivity(sint);
                }
            }
        });
    }
}
