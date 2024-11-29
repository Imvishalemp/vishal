package com.employdemysolutions.core.Services.impl;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.Page;

public interface PageCreationService {

    Page createPage(ResourceResolver resourceResolver);
}


