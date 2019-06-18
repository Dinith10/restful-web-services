package com.promod.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceRestController {

    @Autowired
    private UserDaoService service;

    @GetMapping( value = "/users" )
    public List<User> retriveAllUsers(){

        return service.findAll();
    }

 // retriveUser( int id )
    @GetMapping( value = "/users/{ides}" )
    public User reetriveUser ( @PathVariable(value = "ides" ) int id ) throws Throwable {

         User user = service.findOne(id);


         if(user == null ){

             throw new UserNotFoundException("id-"+id);

         }


        return user;

    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){

      User saveUser =  service.save(user);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }



}
