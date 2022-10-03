package com.example.mid_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.transform.Result;

public class StartActivity extends AppCompatActivity {
    SQLHandler sqlHandler = new SQLHandler();
    Button start_btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        start_btnStart = findViewById(R.id.btn_getStarted);
        start_btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public void gotoSignin() {
        Intent intent = new Intent(StartActivity.this, SigninActivity.class);
        startActivity(intent);
    }
}