package com.example.day4_sharedlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.day4_sharedlist.Modal.Complaint;

public class ComplaintSummaryActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtEStat;
    private TextView txtDesgn;
    private TextView txtLoc;
    private TextView txtEmail;
    private TextView txtCountry;
    private TextView txtDate;
    private TextView txtIssue;
    private TextView txtRating;
    private TextView txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compaint_summary);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Complaint Summary");

        txtName = findViewById(R.id.textView6);
        txtEStat = findViewById(R.id.textView7);
        txtDesgn = findViewById(R.id.textView8);
        txtLoc = findViewById(R.id.textView9);
        txtEmail = findViewById(R.id.textView10);
        txtCountry = findViewById(R.id.textView11);
        txtDate = findViewById(R.id.textView12);
        txtIssue = findViewById(R.id.textView13);
        txtRating = findViewById(R.id.textView14);
        txtDesc = findViewById(R.id.textView15);

        Complaint tempObj = (Complaint) getIntent().getSerializableExtra("complainObj");

        txtName.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtName.setTextSize(20);
        txtName.setText("Name : " + tempObj.getTitle() + " " + tempObj.getFirstName() + " " + tempObj.getLastName());

        txtEStat.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtEStat.setTextSize(20);
        txtEStat.setText("Employee Status : " +tempObj.getEmpStatus());

        txtDesgn.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtDesgn.setTextSize(20);
        txtDesgn.setText("Designation : " + tempObj.getDesignation());

        txtLoc.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtLoc.setTextSize(20);
        txtLoc.setText("Location : " + tempObj.getLocation());

        txtEmail.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtEmail.setTextSize(20);
        txtEmail.setText("Email Address : " + tempObj.getEmail());

        txtCountry.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtCountry.setTextSize(20);
        txtCountry.setText("Country code/Phone No. : " + tempObj.getcountry());

        txtDate.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtDate.setTextSize(20);
        txtDate.setText("Issue Date : " + tempObj.getDate());

        txtIssue.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtIssue.setTextSize(20);
        txtIssue.setText("Type of issue : " + tempObj.getIssue());

        txtRating.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtRating.setTextSize(20);
        txtRating.setText("Rating : " + tempObj.getRating());

        txtDesc.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        txtDesc.setTextSize(20);
        txtDesc.setText("Designation : " + tempObj.getDescription());
    }
}