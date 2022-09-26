package com.example.mid_term;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    RelativeLayout signinRlt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        signinRlt = findViewById(R.id.signinRlt);

        signinRlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SigninActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}