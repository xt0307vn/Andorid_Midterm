package com.example.mid_term;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
        RelativeLayout relativeLayout;
        public CoursesViewHolder(@NonNull View itemView) {
            super(itemView);

            course_name = itemView.findViewById(R.id.item_courseName);
            course_title = itemView.findViewById(R.id.item_courseTitle);
            relativeLayout = itemView.findViewById(R.id.item_Course);
        }
    }
}
