package com.example.mid_term;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CoursesFragment extends Fragment {

    RecyclerView recyclerView;
    CoursesAdapter coursesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.fragment_courseRecycleView);
        coursesAdapter =new CoursesAdapter(getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        coursesAdapter.setData(getlist());
        recyclerView.setAdapter(coursesAdapter);

    }

private List<Courses> getlist() {
    List<Courses> coursesList = new ArrayList<>();
    coursesList.add(new Courses("PHP", "aaaa", "aaaa", "PHP", "aaaa"));
    coursesList.add(new Courses("JavaScript", "aaaa", "aaaa", "JS", "aaaa"));
    coursesList.add(new Courses("HTML", "aaaa", "aaaa", "HTML", "aaaa"));
    coursesList.add(new Courses("Java", "aaaa", "aaaa", "Java", "aaaa"));
    coursesList.add(new Courses("Python", "aaaa", "aaaa", "PY", "aaaa"));
    coursesList.add(new Courses("SQL", "aaaa", "aaaa", "SQL", "aaaa"));
    coursesList.add(new Courses("CSS", "aaaa", "aaaa", "CSS", "aaaa"));
    coursesList.add(new Courses("Bootstrap", "aaaa", "aaaa", "BS", "aaaa"));
    coursesList.add(new Courses("Json", "aaaa", "aaaa", "Json", "aaaa"));
    coursesList.add(new Courses("XML", "aaaa", "aaaa", "XML", "aaaa"));
    coursesList.add(new Courses("MongoDB", "aaaa", "aaaa", "MDB", "aaaa"));
    coursesList.add(new Courses("ReacJS", "aaaa", "aaaa", "RJS", "aaaa"));

    return coursesList;
    }
}