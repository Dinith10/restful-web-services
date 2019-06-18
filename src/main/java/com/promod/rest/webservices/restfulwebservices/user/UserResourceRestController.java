package com.promod.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResourceRestController {

 // retrieveAllUsers
    @Autowired
    private UserDaoService service;

    public List<User> retriveAllUsers(){

        return service.findAll();
    }

 // retriveUser( int id )



}
