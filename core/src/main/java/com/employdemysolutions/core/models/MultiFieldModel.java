package com.employdemysolutions.core.models;

import java.util.*;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiFieldModel {
    @Self
    private Resource resource;
    @ChildResource
    private List<MultiField> actions = new ArrayList<>();

    public List<MultiField> getActions() {
        return actions;
    }

}
