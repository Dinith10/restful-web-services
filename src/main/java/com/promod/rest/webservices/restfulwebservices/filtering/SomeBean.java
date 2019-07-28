package com.promod.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import net.minidev.json.annotate.JsonIgnore;

@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;
    private String field2;




    @JsonIgnore
    private String field3;


    public SomeBean(String value1, String value2, String value3) {
        this.field1 = value1;
        this.field2 = value2;
        this.field3 = value3;
    }


    public String getfield1() {
        return field1;
    }

    public void setfield1(String value1) {
        this.field1 = value1;
    }

    public String getfield2() {
        return field2;
    }

    public void setfield2(String value2) {
        this.field2 = value2;
    }

    public String getfield3() {
        return field3;
    }

    public void setfield3(String value3) {
        this.field3 = value3;
    }
}
