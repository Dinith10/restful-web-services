package com.promod.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {


    private String name;
    private int id;
    private Date birthDay;

    public User() {
    }

    public User(int id, String name, Date birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public int getId() {

        System.out.println("getId AAAAAAAAAAAAAAAAA");


        return id;
    }

    public void setId(int id) {

        System.out.println("setId AAAAAAAAAAAAAAAAA");


        this.id = id;
    }

    public String getName() {

        System.out.println("getName AAAAAAAAAAAAAAAAA");
        return name;
    }

    public void setName(String name) {

        System.out.println("setaName AAAAAAAAAAAAAAAAA");
        this.name = name;
    }

    public Date getBirthDay() {

        System.out.println("getBirthDay BBBBBBBBBBBBBBBBBB");
        return birthDay;
    }

    public void setaBirthDay(Date birthDay) {

        System.out.println("setaBirthDay BBBBBBBBBBBBBBBBBBB");
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}