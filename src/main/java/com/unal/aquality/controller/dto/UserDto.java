package com.unal.aquality.controller.dto;

import com.unal.aquality.model.Rol;
import org.bson.types.ObjectId;

public class UserDto{

    private ObjectId _id;
    private int document;
    private String name;
    private String surname;
    private String username;

    private String email;
    private Rol rol;
    private String password;

    public UserDto() {
    }

    public UserDto(int document, String name, String surname, String username, String email, Rol rol, String password) {
        this.document = document;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.rol = rol;
        this.password = password;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
