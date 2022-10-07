package com.example.mid_term;

import java.sql.ResultSet;

public class SQLHandler {
    public ConnectSQL conn = new ConnectSQL();

    public SQLHandler() {
        conn.connect();
    }

    public void isertUser(String user_name, String user_password, String user_firstname, String user_lastname, String user_phone, String user_email) {
        String query = "insert into Users\n" +
                        "values ( '"+ user_name+"', '"+ user_password+"', N'"+ user_firstname+"', N'"+ user_lastname+"', '"+ user_phone+"', '"+ user_email+"')";
        conn.excute(query);
    }

    public ResultSet getDataUsers() {
        String query = "select * from Users";
        return conn.getData(query);
    }

    public ResultSet getDataUser(String user_name) {
        String query = "select * from Users where user_name = '"+ user_name+"'";
        return conn.getData(query);
    }

    public ResultSet checkSign(String user_name, String user_password) {
        String query = "select * from Users where user_name = '"+ user_name+"' and user_password = '"+ user_password +"'";
        return conn.getData(query);
    }

    public ResultSet getDataCourse(String course_title) {
        String query = "select * from Courses where course_title = '"+ course_title+"'";
        return conn.getData(query);
    }




}
