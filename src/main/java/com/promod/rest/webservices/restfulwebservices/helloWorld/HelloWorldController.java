package com.promod.rest.webservices.restfulwebservices.helloWorld;

import com.promod.rest.webservices.restfulwebservices.helloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {



    // GET
    // URI - /hello-world
    // method - "Hello World"
    @GetMapping( path = "/hello-world")
    public String helloWorld(){



        return  "Hello World Get Mapping";
    }

    @GetMapping( path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){



        return  new HelloWorldBean("hello world bean");
    }


    @GetMapping("/hello-world/path-variaale/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable(value = "name") String name1){


        return  new HelloWorldBean(String.format("Path Variable is %s", name1 ));
    }

}
