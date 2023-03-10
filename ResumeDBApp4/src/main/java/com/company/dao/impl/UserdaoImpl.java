package com.company.dao.impl;

import com.company.bean.User;
import com.company.main.dao.inter.AbstractDao;
import com.company.main.dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserdaoImpl extends AbstractDao implements UserDaoInter{
    @Override
    public List<User> getAll() {
        List<User>result=new ArrayList<>();
        try (Connection c = connect()){

            Statement stmt = c.createStatement();
            stmt.execute("select * from user");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

               result.add(new User(id,name,surname,phone,email));

            }

        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User getById(int userid) {
        User result=null;
        try (Connection c = connect()){

            Statement stmt = c.createStatement();
            stmt.execute("select * from user where id = " + userid);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                result=new User(id,name,surname,phone,email);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
       try(Connection c=connect()){
        PreparedStatement stmt = c.prepareStatement("update user set name =?,surname=?,phone=?,email=? where id =?");
        stmt.setString(1, u.getName());
        stmt.setString(2,u.getSurname());
        stmt.setString(3,u.getPhone());
        stmt.setString(4,u.getEmail());
        stmt.setInt(5, u.getId());
        return  stmt.execute();
    }catch (Exception ex){
           ex.printStackTrace();
           return false;
       }
    }

    @Override
    public boolean removeUser(int id) {
        try(Connection c=connect()){
            Statement stmt = c.createStatement();
            return stmt.execute("delete from  user where id =" + id);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}

