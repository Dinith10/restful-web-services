package com.promod.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {



    // ========== Versioning Using URI's =================== //
    // cons :- URI pollution


    // pros :- Can be cached the URI's are Different
    // pros :- Can be run easyly in browser dont have special knowladge to configur or get plugins


    @GetMapping("v1/person")
    public PersonV1 personV1(){


        return new PersonV1("Bob Charlie");
    }


    @GetMapping("v2/person")
    public PersonV2 personV2(){



        return new PersonV2( new Name("Bob", "Charlie") );


    }


    // ========== Versioning Using Request Parameters =================== //
    // cons :- URI pollution


    // pros :- Can be cached the URI's are Different
    // pros :- Can be run easyly in browser dont have special knowladge to configur or get plugins


    @GetMapping( value = "person/param", params = "version=1" )
    public PersonV1 paramV1(){


        return new PersonV1("Bob Charlie");

    }

    @GetMapping( value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){


        return new PersonV2( new Name("Bob", "Charlie"));

    }



    // ========== Versioning Using Headers (Custom Header Versioning) =================== //
    // cons :- Cannot Cache difficult to cache because All URI's are same
    // cons :- Must Have special knoledge to cfg and send request through header


    // pros :- No URI Pollution

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1" )
    public PersonV1 headerV1(){

        return new PersonV1("Bob Charlie");


    }

    @GetMapping( value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){

        return new PersonV2( new Name("Bob", "Charlie"));

    }


    // ========== Versioning Using Produces (Accept Header Versioning)=================== //
    // cons :- No URI Pollution
    // cons :- Must Have special knoledge to cfg and send request through header


    // pros :-


    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json" )
    public PersonV1 producesV1(){

        return new PersonV1("Bob Charlie");


    }

    @GetMapping( value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){

        return new PersonV2( new Name("Bob", "Charlie"));

    }



}
