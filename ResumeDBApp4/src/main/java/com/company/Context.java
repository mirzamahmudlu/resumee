package com.company;

import com.company.dao.impl.UserdaoImpl;
import com.company.main.dao.inter.UserDaoInter;

public class Context {

    public static UserDaoInter instanceUserDao(){
        return new  UserdaoImpl();
    }
}
