package com.employdemysolutions.core.servlets;

import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(
    service = Servlet.class,
    property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Path-Based Servlet",
        ServletResolverConstants.SLING_SERVLET_PATHS + "=/bin/",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.methods=" + HttpConstants.METHOD_POST
    }
)
public class TestServletPathBased extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String inputData = request.getParameter("data");
        response.setContentType("text/plain");
        if (inputData != null) {
            response.getWriter().write("Hello, you sent this data via GET: " + inputData);
        } else {
            response.getWriter().write("Hello, no data parameter was provided.");
        }
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String inputData = request.getParameter("data");
        response.setContentType("text/plain");
        response.getWriter().write("Hello, you sent this data via POST: " + inputData);
    }
}
