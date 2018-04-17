package com.tecnoinfsanjose.tareaandroiduno.Controllers;

import android.media.Image;

import com.tecnoinfsanjose.tareaandroiduno.Clases.Reserva;
import com.tecnoinfsanjose.tareaandroiduno.Clases.User;
import com.tecnoinfsanjose.tareaandroiduno.DAO.UserModel;

import java.util.Date;
import java.util.List;

public class UserControler {
     UserModel model = new UserModel();


    public void login(String user, String pass){
        model.login(user,pass);
    }

    public void registrar(String correo, String nombre, String apellido, String contraseña,
                             String documento, String telefono, String direccion, String ciudad, String rol) throws Exception{
         //el throws exception larga la excepcion para arriba para la vista
         if(nombre.isEmpty()) throw new Exception("El nombre no puede ser vacio");
         User user = new User(correo,nombre,apellido,contraseña,documento,telefono,direccion,ciudad,rol);
         model.registrar(user);
    }

    public void confirmarcliente(User user, Date FechaReserva, Image Imagen){
        Reserva reserva = new Reserva(user,FechaReserva,Imagen,false);
        model.nuevaReserva(reserva);
    }

    public void cancelarempleado(User user, Date FechaReserva, Image Imagen){
        Reserva reserva = new Reserva(user,FechaReserva,Imagen,true);
        model.cancelarReserva(reserva);
    }

    public void logout(User user){
         model.logout(user);
    }

    public List<User> dameuser(){
        return model.dameuser();
    }
}
