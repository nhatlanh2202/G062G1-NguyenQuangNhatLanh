package com.codegym.dao;

import com.codegym.entity.Login;
import com.codegym.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("Lanh");
        u1.setAccount("lanh");
        u1.setEmail("lanh@codegym.vn");
        u1.setPassword("123");
        users.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Phong");
        u2.setAccount("phong");
        u2.setEmail("phong@codegym.vn");
        u2.setPassword("123");
        users.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Le");
        u3.setAccount("le");
        u3.setEmail("le@codegym.vn");
        u3.setPassword("123");
        users.add(u3);
    }

    public static User checkLogin(Login login){
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
