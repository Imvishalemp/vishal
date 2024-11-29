package com.employdemysolutions.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;
import org.apache.sling.api.servlets.ServletResolverConstants;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(
    service = Servlet.class,immediate = true,
    property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Resource-Based Servlet",
        ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES + "=/apps/employdemy-solutions/components/multiField/cq:dialog/content/items/actions/field/items/text",
        "sling.servlet.methods=" + "GET"
    }
)
public class BasicServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String message = request.getResource().getValueMap().get("transText", String.class);
        response.setContentType("text/plain");
        if (message != null) {
            response.getWriter().write("Message from resource: " + message);
        } else {
            response.getWriter().write("No message found in the resource.");
        }
    }
}