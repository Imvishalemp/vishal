package com.employdemysolutions.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;



@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Task3 {

@ValueMapValue
String text;
@ValueMapValue
Boolean checkbox1;
@ValueMapValue
Boolean checkbox2;
@ValueMapValue
String image;
@ValueMapValue
String pathfield;


public String getText() {
    return text;
}
public Boolean getcheckbox1() {
    return checkbox1;
}
public Boolean getcheckbox2() {
    return checkbox2;
}
public String getImage() {
    return image;
}
public String getPathfield() {
    return pathfield;
}


}
