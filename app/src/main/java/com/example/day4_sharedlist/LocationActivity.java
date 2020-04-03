package com.example.day4_sharedlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class LocationActivity extends AppCompatActivity {

    private Button btnSave;
    private EditText edtStreet;
    private EditText edtCity;
    private EditText edtPostal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loaction);

        ActionBar actBar =getSupportActionBar();
        actBar.setTitle("Location Form");

        edtStreet = findViewById(R.id.editText3);
        edtCity = findViewById(R.id.editText4);
        edtPostal = findViewById(R.id.editText5);

        btnSave = findViewById(R.id.button2);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String street = edtStreet.getText().toString().trim();
                String city = edtCity.getText().toString().trim();
                String postal = edtPostal.getText().toString().trim();
                if (street.isEmpty()) {
                    edtStreet.setError("Please enter Street");
                } else if (city.isEmpty()) {
                    edtCity.setError("Please enter city");
                } else if (postal.isEmpty()) {
                    edtPostal.setError("Please enter postal code");
                } else {
                    Intent locint = new Intent(LocationActivity.this, MainActivity.class);
                  //  Bundle lbun = new Bundle();
                  //  lbun.putString("street", street);
                  //  lbun.putString("city", city);
                  //  lbun.putString("postal", postal);
                    startActivity(locint);
                }
            }
        });
    }
}

