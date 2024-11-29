package com.employdemysolutions.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import com.employdemysolutions.core.Services.PracticeService;
@Component(service ={Servlet.class})
@SlingServletResourceTypes(
    resourceTypes="employdemy-solutions/components/task3",
    methods=HttpConstants.METHOD_GET,
    extensions="txt"
)
@ServiceDescription("Simple Demo Servlet")
public class ResourecTypeServlet extends SlingSafeMethodsServlet{

@Reference
PracticeService practiceService;

@Override
protected void doGet(final SlingHttpServletRequest rep,final SlingHttpServletResponse resp) 
throws IOException{
    resp.setContentType("text/plain");
    resp.getWriter().write("hello bro "+ practiceService.getName());
}
}
