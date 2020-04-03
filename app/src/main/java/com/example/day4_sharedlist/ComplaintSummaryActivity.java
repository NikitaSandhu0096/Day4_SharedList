package com.example.day4_sharedlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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

        ActionBar actBar =getSupportActionBar();
        actBar.setTitle("Complaint Summary");

        txtName = findViewById(R.id.textView6);
        txtEStat= findViewById(R.id.textView7);
        txtDesgn = findViewById(R.id.textView8);
        txtLoc = findViewById(R.id.textView9);
        txtEmail = findViewById(R.id.textView10);
        txtCountry = findViewById(R.id.textView11);
        txtDate = findViewById(R.id.textView12);
        txtIssue = findViewById(R.id.textView13);
        txtRating = findViewById(R.id.textView14);
        txtDesc=findViewById(R.id.textView15);
    }
}
