package com.example.mid_term;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfileFragment extends Fragment {
    private MainActivity mainActivity;
    TextView profile_username, profile_userid, profile_fullname, profile_phone, profile_email;
    Button profile_signout;
    String user_fullname, user_name, user_id, user_phone, user_email;
    SQLHandler sqlHandler = new SQLHandler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        user_name = mainActivity.user_name;
        getDataUser();

        return inflater.inflate(R.layout.fragment_frofile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        connectID(view);
        setViewDataUser(view);
        gotoSignin();

    }

    public void gotoSignin() {
        profile_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SigninActivity.class);
                startActivity(intent);
            }
        });
    }

    public void cli() {
        profile_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "444", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void connectID(View view) {
        profile_email = view.findViewById(R.id.profile_edtEmail);
        profile_phone = view.findViewById(R.id.profile_edtPhone);
        profile_fullname = view.findViewById(R.id.profile_edtFullname);
        profile_username = view.findViewById(R.id.profile_usename);
        profile_userid = view.findViewById(R.id.profile_id);
        profile_signout = view.findViewById(R.id.progile_signout);
    }

    public void getDataUser() {
        if(checkUser_name(user_name)) {
            try {
                ResultSet rs = sqlHandler.getDataUser(user_name);
                while(rs.next()) {
                    user_fullname = rs.getString("user_firstname") + " " + rs.getString("user_lastname");
                    user_id = String.valueOf(rs.getInt("user_id"));
                    user_phone = rs.getString("phone");
                    user_email = rs.getString("email");
                }

            }catch (Exception e) {
                user_email = e.getMessage();
            }
        } else {
            Toast.makeText(getActivity(), "No exists data", Toast.LENGTH_SHORT).show();
        }
    }

    public void setViewDataUser(View view) {
        profile_username.setText(user_name);
        profile_fullname.setText(user_fullname);
        profile_userid.setText(user_id);
        profile_phone.setText(user_phone);
        profile_email.setText(user_email);
    }

    public boolean checkUser_name(String user_name) {
        try {
            ResultSet rs =  rs = sqlHandler.getDataUsers();
            while(rs.next()) {
                if(user_name.equalsIgnoreCase(rs.getString("user_name"))){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}