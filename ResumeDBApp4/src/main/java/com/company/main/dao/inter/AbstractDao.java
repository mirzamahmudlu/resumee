package com.company.main.dao.inter;

import com.company.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract  class AbstractDao {

    public  Connection connect()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/resume";
        String username="root";
        String password="12345";
        Connection c= DriverManager.getConnection(url,username,password);
        return c;
    }


}
