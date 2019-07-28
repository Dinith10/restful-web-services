package com.promod.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResourceRestController {

    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository userRepository;



    @GetMapping( value = "/jpa/users" )
    public List<User> retriveAllUsers(){ System.out.println("AAAAAAAAAAAA");

        return userRepository.findAll();
    }

// // retriveUser( int id )
//    @GetMapping( value = "/jpa/users/{ides}" )
//    public Resource reetriveUser (@PathVariable(value = "ides" ) int id ) throws Throwable {
//
//         Optional<User> user = userRepository.findById(id);
//
//
//         if( !user.isPresent() ){
//
//             throw new UserNotFoundException("id- mns "+id);
//
//         }
//
//
//
//         Resource  resource = new Resource(user.get());
//
//        return resource;
//
//
//    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser( @Valid @RequestBody User user){

      User saveUser =  service.save(user);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping( value = "/jpa/users/{ides}" )
    public void deleteUser ( @PathVariable(value = "ides" ) int id ) throws Throwable {

      userRepository.deleteById(id);





//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
//
//        return ResponseEntity.noContent().build();
//




    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retriveUser(@PathVariable("id") int ides ){

        Optional<User> userOptional = userRepository.findById(ides);

        if( !userOptional.isPresent() ){

            throw new UserNotFoundException("id-"+ides);    }


        return userOptional.get().getPost();

    }

    // HATEOS

//    @GetMapping( value = "/jpa/users/{ides}" )
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
