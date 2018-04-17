package com.tecnoinfsanjose.tareaandroiduno.Clases;

import android.media.Image;

import java.util.Date;

public class Reserva {
    private User Cliente;
    private Date FechaReserva;
    private Image Imagen;
    private boolean Cancelada;

    public Reserva(User cliente, Date fechaReserva, Image imagen, boolean cancelada) {
        Cliente = cliente;
        FechaReserva = fechaReserva;
        Imagen = imagen;
        Cancelada = cancelada;
    }

    public boolean isCancelada() {
        return Cancelada;
    }

    public void setCancelada(boolean cancelada) {
        Cancelada = cancelada;
    }

    public User getCliente() {

        return Cliente;
    }

    public void setCliente(User cliente) {
        Cliente = cliente;
    }

    public Date getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        FechaReserva = fechaReserva;
    }

    public Image getImagen() {
        return Imagen;
    }

    public void setImagen(Image imagen) {
        Imagen = imagen;
    }
}
