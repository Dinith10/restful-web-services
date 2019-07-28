package com.promod.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "All details about the user. ")
@Entity
public class User {

    @Size(min = 2, message = "Name Should Have At Least 2 Characters" )
    @ApiModelProperty( notes = "Name Should Have At Least 2 Characters" )
    private String name;


    @Id
    @GeneratedValue
    private int id;

    @Past
    @ApiModelProperty( notes = "Birth day should be in past" )
    private Date birthDay;


    @OneToMany(mappedBy = "user")
    private List<Post> post;

    public User() {
    }


    public User(int id, String name, Date birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public int getId() {

        System.out.println("getId "+ this.id);


        return id;
    }

    public void setId(int id) {

        System.out.println("setId "+id);


        this.id = id;
    }


    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }


    public String getName() {

        System.out.println("getName "+this.name);
        return name;
    }

    public void setName(String name) {

        System.out.println("setName "+ name);
        this.name = name;
    }

    public Date getBirthDay() {

        System.out.println("getBirthDay "+this.birthDay);
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {

        System.out.println("setaBirthDay " + birthDay);
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}