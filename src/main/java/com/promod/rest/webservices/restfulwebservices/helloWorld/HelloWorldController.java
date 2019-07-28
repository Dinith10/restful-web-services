package com.promod.rest.webservices.restfulwebservices.helloWorld;

import com.promod.rest.webservices.restfulwebservices.helloWorld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

// Controller
@RestController
public class HelloWorldController {


    @Autowired
    private MessageSource messageSource ;



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

    @GetMapping(path = "/hello-world-internationalizedOldWay")
    public String helloWorldInternationalizedOldWay( @RequestHeader( name = "Accept-Language", required = false ) Locale locale ){

        System.out.println(locale);
        return messageSource.getMessage("good.morning.message", null, locale);

    }


    @GetMapping( path = "/hello-world-internationalizedNewWay" )
    public String helloWorldInternationalizedNewWay(){

        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());



    }





}
