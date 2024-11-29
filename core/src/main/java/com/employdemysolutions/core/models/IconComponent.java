package com.employdemysolutions.core.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.dam.cfm.ContentFragment;
import com.day.cq.wcm.api.Page;


@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class IconComponent {

    @ScriptVariable
    Page page;
    ContentFragment cf;
    @SlingObject
    private Resource res;

    @ValueMapValue
    String title;

    @ValueMapValue
    String titleType;

    
    @ValueMapValue
    String description;

    @ValueMapValue
    String color;

    @ChildResource
    List<IconComponentModel> actions=new ArrayList<>();
    void init(){
        NamingModel pageclass=page.adaptTo(NamingModel.class);
       Resource pageRes= page.getContentResource();

       ContentFragment model=res.getResourceResolver().adaptTo(ContentFragment.class);
       
    }

    public List<IconComponentModel> getActions() {
        return actions;
    }
    

    public String getTitle() {
        return title;
    }

    public String getTitleType() {
        return titleType;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    

    





    

}
