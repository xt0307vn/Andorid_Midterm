package com.example.mid_term;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;

public class SigninActivity extends AppCompatActivity {
    EditText signin_username, signin_password;
    TextView signin_linksignup;
    Button signin_btn;
    SQLHandler sqlHandler = new SQLHandler();
    String user_name, user_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        connectIDLayout();
        signin_linksignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSignup();
            }
        });

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInput();
                if(checkInput()) {
                    if(checkUser_name(user_name)) {
                        if(checkUser_password(user_name, user_password)) {
                            showDialogOk("Sign in successfully");
                            gototMain(user_name);
                        } else {
                            showDialogOk("Password false");
                        }

                    } else {
                        showDialogOk("Username not exists");
                    }
                } else {
                    showDialogOk("Cannot be blank");
                }
            }
        });
    }

    public void connectIDLayout() {
        signin_username = findViewById(R.id.signin_edtUsername);
        signin_password = findViewById(R.id.signin_edtPassword);
        signin_linksignup = findViewById(R.id.link_signup);
        signin_btn = findViewById(R.id.signin_btnSignin);
    }

    public void gotoSignup() {
        Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
        startActivity(intent);
    }

    public void gotoMain(int id) {
        Intent intent = new Intent(SigninActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        bundle.putBundle("data", bundle);
        startActivity(intent);
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

    public boolean checkUser_password(String user_name, String user_password) {
        try {
            ResultSet rs =  rs = sqlHandler.checkSign(user_name, user_password);
            while(rs.next()) {
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getInput() {
        user_name = signin_username.getText().toString().trim();
        user_password = signin_password.getText().toString().trim();
    }

    public boolean checkInput() {
        if(user_name.isEmpty() || user_password.isEmpty()) {
            return false;
        }
        return true;
    }

    public void showDialogOk(String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

    public void gototMain(String user_name) {
        Intent intent = new Intent(SigninActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_name", user_name);
        intent.putExtra("dataUser", bundle);
        startActivity(intent);
    }
}