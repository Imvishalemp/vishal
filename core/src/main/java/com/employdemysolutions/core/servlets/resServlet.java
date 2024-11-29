package com.employdemysolutions.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.wcm.api.Page;
import com.employdemysolutions.core.Services.impl.PageCreationService;

@Component(service = Servlet.class,
property = {
"sling.servlet.resourceTypes=" + "employdemy-solutions/components/text", 
"sling.servlet.methods=" + HttpConstants.METHOD_GET

})
public class resServlet extends SlingSafeMethodsServlet {

    @Reference
    private PageCreationService pageCreationService;

    ResourceResolver resourecResolver;

    @Override
    protected  void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp ) throws IOException
    {
        
        try {
            resourecResolver = req.getResourceResolver();
            Page page = pageCreationService.createPage(resourecResolver);

            if (page != null) {
                resp.getWriter().write("Page created usinng resource successfully at: " + page.getPath());
            } else {
                resp.getWriter().write("Failed to create page by usinng resource.");
            }
        } catch (Exception e) {
            resp.getWriter().write("An error occurred by usinng resource: " + e.getMessage());
        }

    }

}
