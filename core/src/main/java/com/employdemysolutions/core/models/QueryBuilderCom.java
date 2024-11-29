package com.employdemysolutions.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.employdemysolutions.core.Services.impl.QueryService;

@Model(adaptables = {Resource.class } , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )
public class QueryBuilderCom {

    @ValueMapValue
    private String pathField;

    @ValueMapValue
    private List<String> tag;

    public String getPathField() {
        return pathField;
    }

    public List<String> getTag() {
        return tag;
    }

     @OSGiService
    private QueryService queryService;

    @Self
    private Resource resource;

    private List<String> pages;

    public List<String> getPages() {
        if (pages == null) {
            pages = queryService.fetchPages(resource);
        }
        return pages;
    }

    

}
