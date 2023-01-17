import com.company.Context;
import com.company.bean.User;
import com.company.dao.impl.UserdaoImpl;
import com.company.main.dao.inter.UserDaoInter;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{

        UserDaoInter userDao = Context.instanceUserDao();
         User u=userDao.getById(1);
         u.setName("Azay");
         userDao.updateUser(u);
}
}

