package com.employdemysolutions.core.Services.impl;




import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;


@Component(service = PageCreationService.class, immediate = true)
public class PageCreationServiceImpl implements PageCreationService{

    @Override
    public Page createPage(ResourceResolver resourceResolver) {
        // Set the details you provided here
        String parentPath = "/content/employdemy-solutions/us/en";
        String pageName = "creatingPage";
        String templatePath = "/conf/employdemy-solutions/settings/wcm/templates/landingtempone";
        String title = "vishal";

        Page page = null;
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            if (pageManager != null) {
                try {
                    page = pageManager.create(parentPath, pageName, templatePath, title);
                } catch (WCMException e) {
                    e.printStackTrace();
                }
            }

        return page;
    }
}

