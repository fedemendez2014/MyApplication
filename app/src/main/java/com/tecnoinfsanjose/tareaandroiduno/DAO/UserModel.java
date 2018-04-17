package com.tecnoinfsanjose.tareaandroiduno.DAO;

import android.content.SharedPreferences;

import com.tecnoinfsanjose.tareaandroiduno.Clases.Reserva;
import com.tecnoinfsanjose.tareaandroiduno.Clases.User;
import com.tecnoinfsanjose.tareaandroiduno.Persistencia.PersistenciaDB;

import java.util.List;

public class UserModel {

    public UserModel() {
    }

    public void login(String user, String pass){
        for(User u: PersistenciaDB.userlist) {
            if(u.getCorreo() == user && u.getContraseña() == pass){

            }
        }
    }

    public void registrar(User user) throws Exception{
        try{
            PersistenciaDB.insertBase(user);
        }
        catch(Exception e){

        }
    }

    public void nuevaReserva(Reserva reserva){
        //persisto la nueva reserva
    }

    public void cancelarReserva(Reserva reserva){
        //Hago un update con la reserva en cancelado true
    }

    public void logout(User user){
        //rompo la session y devulevo true
    }

    public List<User> dameuser(){
        return PersistenciaDB.userlist;
    }
}
