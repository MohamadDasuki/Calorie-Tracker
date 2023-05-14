package com.example.csi370_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button login1,signup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login1=findViewById(R.id.BTNlogin1);
        signup1=findViewById(R.id.BTNsignup1);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Loginpage.class);
                startActivity(i);
                finish();
            }
        });

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(MainActivity.this,Signuppage.class);
                startActivity(ii);
                finish();
            }
        });
    }
}