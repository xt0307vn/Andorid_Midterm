package com.example.mid_term;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CoursesViewHolder> {

    private Context context;
    private List<Courses> coursesList;

    public CoursesAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Courses> coursesList) {
        this.coursesList = coursesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_course, parent, false);
        return new CoursesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesViewHolder holder, int position) {
        Courses courses =coursesList.get(position);
        if(courses == null) {
            return;
        }
        holder.course_name.setText(courses.getCourse_name());
        holder.course_title.setText(courses.getCourse_title());


        holder.backgroundTitle.setBackgroundColor(Color.argb(255, setColorRed(), setColorBlue(), setColorGreen()));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, holder.course_name.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(coursesList != null) {
            return coursesList.size();
        }
        return 0;
    }

    public class CoursesViewHolder extends RecyclerView.ViewHolder{

        private TextView course_title, course_name;
        RelativeLayout relativeLayout, backgroundTitle;
        public CoursesViewHolder(@NonNull View itemView) {
            super(itemView);

            course_name = itemView.findViewById(R.id.item_courseName);
            course_title = itemView.findViewById(R.id.item_courseTitle);
            relativeLayout = itemView.findViewById(R.id.item_Course);
            backgroundTitle = itemView.findViewById(R.id.item_backgroundTitle);
        }
    }

    public int setColorRed() {
        Random random = new Random();
        int r = random.nextInt(255);
        return r;
    }
    public int setColorGreen() {
        Random random = new Random();
        int g = random.nextInt(255);
        return g;
    }
    public int setColorBlue() {
        Random random = new Random();
        int b = random.nextInt(255);
        return b;
    }

}
