package com.unal.aquality.model;
enum Rol {
    LOCAL, ADMIN;
}

public class User {

    private String name;
    private String surname;
    private String username;
    private String email;
    private Rol rol;
    private String password;

    public User(String name, String surname, String username, String email, Rol rol, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.rol = rol;
        this.password = password;
    }
}
