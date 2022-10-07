package com.example.mid_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity {
    TextView coursedetail_coursewhat, coursedetail_coursewhy, coursedetail_title;
    String course_name, course_title;
    ImageView detail_btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursedetail);
        coursedetail_title = findViewById(R.id.course_title);
        coursedetail_coursewhat = findViewById(R.id.course_what);
        coursedetail_coursewhy = findViewById(R.id.course_why);
        detail_btnBack = findViewById(R.id.detail_btnBack);


        Intent intent = getIntent();
        course_name = intent.getStringExtra("course_name");
        course_title = intent.getStringExtra("course_title");

        coursedetail_title.setText(course_title);
        coursedetail_coursewhat.setText("What is " + course_name);
        coursedetail_coursewhy.setText("Why study " + course_name);

        detail_btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}