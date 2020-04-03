package com.example.day4_sharedlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ComplaintSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compaint_summary);

        ActionBar actBar =getSupportActionBar();
        actBar.setTitle("Complaint Summary");
    }
}
