package com.promod.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {



    @GetMapping("/filtering")
    public SomeBean retriveSomeBean(){


        return  new SomeBean("value1", "value2", "value3");


    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retriveListOfSomeBean(){


        return  Arrays.asList( new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32")

        );


    }



    // send field1, field2 dont send field3
    @GetMapping(path = "/dynamic-filtering")
    public MappingJacksonValue retriveSomeBeanDynamicFiltering(){

        SomeBean someBean = new SomeBean("valiue1","value2","value3");


        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");


        FilterProvider filters = new SimpleFilterProvider().addFilter( "SomeBeanFilter", filter );


        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        mapping.setFilters(filters);

        return mapping;

    }

    // send field2, field3 dont send field1
    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue retriveListOfSomeBeanDynamicFiltering(){


       List<SomeBean> list =  Arrays.asList( new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

        FilterProvider filters = new SimpleFilterProvider().addFilter( "SomeBeanFilter", filter );


        MappingJacksonValue mapping = new MappingJacksonValue(list);

        mapping.setFilters(filters);


    return mapping;

    }



}
