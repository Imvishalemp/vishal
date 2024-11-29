package com.employdemysolutions.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class IconComponentModel {

    @Self
    Resource resource;

    @ValueMapValue
    private String icon;

    @ValueMapValue
    private String iconTitle;

    @ValueMapValue
    private String iconDescription;

    @ValueMapValue
    private String pathLink;

    @ValueMapValue
    private String buttonName;

    public String getIcon() {
        return icon;
    }

    public String getIconTitle() {
        return iconTitle;
    }

    public String getIconDescription() {
        return iconDescription;
    }

    public String getPathLink() {
        return pathLink;
    }

    public String getButtonName() {
        return buttonName;
    }

}

