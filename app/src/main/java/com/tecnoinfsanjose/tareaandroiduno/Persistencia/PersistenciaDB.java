package com.tecnoinfsanjose.tareaandroiduno.Persistencia;

import com.tecnoinfsanjose.tareaandroiduno.Clases.User;

import java.util.ArrayList;
import java.util.List;

public class PersistenciaDB {

    public static List<User> userlist =  new ArrayList<User>();

    public static void insertBase(User user){
        userlist.add(user);
    }

    public PersistenciaDB() {

    }
}
