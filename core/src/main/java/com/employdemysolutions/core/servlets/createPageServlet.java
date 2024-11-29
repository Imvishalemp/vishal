package com.employdemysolutions.core.servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import com.day.cq.wcm.api.Page;
import com.employdemysolutions.core.Services.impl.PageCreationService;

@Component(service = Servlet.class , property = {
    "sling.servlet.methods=GET",
    "sling.servlet.paths=/bin/creatingPage"  
    //to creating the page we have go in to the page  in component root take the 
    // sling resource type use that path hit it 
    // it will create the page
} )
@ServiceDescription("Simple Demo Servlet")
public class createPageServlet extends SlingSafeMethodsServlet {

    @Reference
    private PageCreationService pageCreationService;

    ResourceResolver resourecResolver;

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resourecResolver = req.getResourceResolver();
            Page page = pageCreationService.createPage(resourecResolver);

            if (page != null) {
                resp.getWriter().write("Page created successfully at: " + page.getPath());
            } else {
                resp.getWriter().write("Failed to create page.");
            }
        } catch (Exception e) {
            resp.getWriter().write("An error occurred: " + e.getMessage());
        }
    }
}
