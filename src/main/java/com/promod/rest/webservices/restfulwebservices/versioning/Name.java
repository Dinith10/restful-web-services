package com.promod.rest.webservices.restfulwebservices.versioning;

public class Name {

private String firstName;
private String SecondName;

    public Name() {
    }

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        SecondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }
}
