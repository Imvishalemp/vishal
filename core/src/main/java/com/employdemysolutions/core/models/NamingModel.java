package com.employdemysolutions.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class , SlingHttpServletRequest.class} , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )
public class NamingModel {

    @ValueMapValue
    private String firstName;

    @ValueMapValue
    private String lastName;

    @ValueMapValue
    private Boolean checkbox1;

    @ValueMapValue
    private String age;

    private String fullName;
    private String name;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getCheckbox1() {
        return checkbox1;
    }

    public String getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getName() {
        return name;
    }

    public boolean isFlag() {
        return flag;
    }

    boolean flag=false;

    @PostConstruct
    public void init() {
        // Merge first name and last name if checkbox1 is true
        // if (Boolean.TRUE.equals(checkbox1)) {
            fullName = firstName + " " + lastName;
        // } else {
        //     fullName = firstName;
        // }

        try {
            int ageInt = Integer.parseInt(age);
            if (ageInt >= 18) {
              flag=true;
            } else {
               flag=false;
            }
        } catch (NumberFormatException e) {
            name = "Invalid age provided";
        }

    }

}
