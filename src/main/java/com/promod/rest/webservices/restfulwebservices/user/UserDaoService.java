package com.promod.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = users.size();


    static {


        users.add( new User( 1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));


    }

    public List<User> findAll(){



        return users;

    }


    public User save(User user){

        if (user.getId() == 0 ){

            user.setId(++usersCount);
        }

        users.add(user);

        return user;
    }



    public User findOne( int id ){

        for( User user : users ){


            if( user.getId() == id){

                return user;

            }


        }

        return null;


    }

}
