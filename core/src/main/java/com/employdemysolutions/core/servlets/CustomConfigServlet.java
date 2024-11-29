package com.employdemysolutions.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.employdemysolutions.core.Services.CustomConfigService;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(
    service = Servlet.class,
    property = {
        "sling.servlet.paths=/bin/getChatbotDetails",
        "sling.servlet.methods=GET"
    }
)
public class CustomConfigServlet extends SlingAllMethodsServlet {


    @Reference
    private CustomConfigService customConfigService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String chatbotDetails = customConfigService.getChatbotDetails();
        response.getWriter().write("these are the details "+chatbotDetails);
    }
}
