package com.example.csi370_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage extends AppCompatActivity {
Button login2;
EditText id1,username1;
SQLiteDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        login2=findViewById(R.id.BTNlogin2);
        id1=findViewById(R.id.ETid1);
        username1=findViewById(R.id.ETusername1);

        myDb = openOrCreateDatabase("productsDB", Context.MODE_PRIVATE, null);
        myDb.execSQL("CREATE TABLE IF NOT EXISTS products(id VARCHAR,username VARCHAR,age VARCHAR,weight VARCHAR,height VARCHAR,gender VARCHAR)");

        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id1.getText().toString().trim().length() == 0 ||
                    username1.getText().toString().trim().length() == 0) {
                    Toast.makeText(Loginpage.this, "All Fields Are Required", Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor c = myDb.rawQuery("SELECT * FROM products WHERE id='" + id1.getText() + "'", null);
                Cursor cc = myDb.rawQuery("SELECT * FROM products WHERE username='" + username1.getText() + "'", null);
                StringBuffer buffer = new StringBuffer();
                if(c.moveToFirst() && cc.moveToFirst()) {
                        buffer.append("ID: "+c.getString(0));
                        buffer.append("\nUsername: "+c.getString(1));
                        buffer.append("\nAge "+c.getString(2));
                        buffer.append("\nWeight "+c.getString(3));
                        buffer.append("\nHeight "+c.getString(4));
                        buffer.append("\nGender "+c.getString(5));
                        buffer.append("\n---------------------\n");
                    Intent a=new Intent(Loginpage.this,Profile.class);
                    a.putExtra("PRODUCTS",buffer.toString());
                    startActivity(a);
                } else

                    Toast.makeText(Loginpage.this, " ID or Username incorrect", Toast.LENGTH_SHORT).show();

            }
        });

    }
}