package com.unal.aquality.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;

 enum Rol {
    LOCAL, ADMIN;
}

@Document(collection = "Users")
public class User {

    @Id
    private ObjectId _id;

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

    public String getName() {
        return name;
    }

    // ObjectId needs to be converted to string
    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId id) {
        this._id = id;
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


    public String toString(){
        return name+" "+surname + " "+ username +" "+email +" "+rol+" "+password;
    }

    public ArrayList<String> noNull(){
        ArrayList<String> hey = new ArrayList<>();
        if(name==null||name.equals("")){
            hey.add("name");
        }
        if(surname==null){
            hey.add("surname");
        }
        if(email==null||email.equals("")){
            hey.add("email");
        }
        if(rol==null){
            hey.add("rol");
        }
        if(password==null||password.equals("")){
            hey.add("password");
        }
        return hey;
    }

    public ArrayList<String> GramareRr(){
        ArrayList<String> hey = new ArrayList<>();


        for(int i =0;i<name.length();i++){
            if(!((name.charAt(i)>=65&&name.charAt(i)<=90)||(name.charAt(i)>=97&&name.charAt(i)<=122))) {
                hey.add("name");
                i=name.length();
            }
        }
        for(int i =0;i<surname.length();i++){
            if(!((surname.charAt(i)>=65&&surname.charAt(i)<=90)||(surname.charAt(i)>=97&&surname.charAt(i)<=122))) {
                hey.add("surname");
                i=surname.length();
            }
        }
        if(password.length()<6){
            hey.add("password");
        }
        return hey;
    }

    public HashMap<String,ArrayList<String>> Error(){
        HashMap<String,ArrayList<String>> hey = new HashMap<>();
        if(!noNull().isEmpty()){
            hey.put("null",noNull());

        }else{
            ArrayList<String> gram = GramareRr();
            if(!gram.isEmpty()){
                hey.put("gram",gram);
            }
        }
        return hey;
    }
}
