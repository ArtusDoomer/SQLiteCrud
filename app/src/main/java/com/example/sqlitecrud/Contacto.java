package com.example.sqlitecrud;


public class Contacto {
    int id;

    String nombre;
    String apellido;
    String email;
    String telefono;
    String ciudad;

    public Contacto(){

    }
    public Contacto(String nombre, String apellido, String email, String telefono, String ciudad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }
    public Contacto(int id, String nombre, String apellido, String email, String telefono, String ciudad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public int getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    public String GetNombre(){
       return nombre;
    }
    public void setNombre(){
        this.nombre = nombre;
    }
    public String GetApellido(){
        return apellido;
    }
    public void setApellido(){
        this.apellido = apellido;
    }
    public String GetEmail(){
        return email;
    }
    public void setEmail(){
        this.nombre = email;
    }
    public String GetTelefono(){
        return telefono;
    }
    public void setTelefono(){
        this.telefono = telefono;
    }
    public String GetCiudad(){
        return ciudad;
    }
    public void setCiudad(){
        this.ciudad = ciudad;
    }

}
