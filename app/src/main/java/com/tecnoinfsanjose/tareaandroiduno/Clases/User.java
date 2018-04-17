package com.tecnoinfsanjose.tareaandroiduno.Clases;

public class User {
    private String correo;
    private String Nombre;
    private String Apellido;
    private String Contraseña;
    private String Documento;
    private String Telefono;
    private String Direccion;
    private String Ciudad;
    private String Rol;

    public String getCorreo() {
        return correo;
    }

    public User(String correo, String nombre, String apellido, String contraseña, String documento, String telefono, String direccion, String ciudad, String rol) {
        this.correo = correo;
        Nombre = nombre;
        Apellido = apellido;
        Contraseña = contraseña;
        Documento = documento;
        Telefono = telefono;
        Direccion = direccion;
        Ciudad = ciudad;
        Rol = rol;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }
}
