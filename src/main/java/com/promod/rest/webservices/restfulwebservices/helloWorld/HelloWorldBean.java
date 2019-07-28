package com.promod.rest.webservices.restfulwebservices.helloWorld;

public class HelloWorldBean {

    private String message;


    public HelloWorldBean(String message) {


        this.message = message;

    }

    public String getMessage() {

        System.out.println("getMessage " + this.message);


        return message;
    }

    public void setMessage(String message) {

        System.out.println("setMessage " + message);


        this.message = message;
    }




    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }


}
