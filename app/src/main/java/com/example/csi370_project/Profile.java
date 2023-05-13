package com.example.csi370_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
TextView infodisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        infodisplay=findViewById(R.id.TVinfodisplay);

        Intent a = getIntent();
        infodisplay.setText(a.getStringExtra("PRODUCTS"));

    }
}