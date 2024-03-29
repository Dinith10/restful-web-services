package com.promod.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
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

             throw new UserNotFoundException("id- mns "+id);

         }


        return user;

    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser( @Valid @RequestBody User user){

      User saveUser =  service.save(user);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping( value = "/users/{ides}" )
    public User deleteUser ( @PathVariable(value = "ides" ) int id ) throws Throwable {

        User user = service.deleteById(id);


        if(user == null ){

            throw new UserNotFoundException("id- mns "+id);

        }



//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
//
//        return ResponseEntity.noContent().build();
//



        return user;

    }

    // HATEOS

//    @GetMapping( value = "/users/{ides}" )
//    public Resource<User> reetriveUser ( @PathVariable(value = "ides" ) int id ) throws Throwable {
//
//        User user = service.findOne(id);
//
//
//        if(user == null ){
//
//            throw new UserNotFoundException("id- mns "+id);
//
//        }
//
//       Resource <User> resource = new Resource<User>(user);
//
//        ControllerLinkBuilder linkto = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
//
//        resource.add(linkto.withRel("all-users"));
//
//        return resource;
//
//    }
//







}
