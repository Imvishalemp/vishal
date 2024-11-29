package com.employdemysolutions.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.event.jobs.JobManager;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service=Servlet.class,
     property={
        Constants.SERVICE_DESCRIPTION + "=Custom Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/vishal/practice"
     }

)
public class PracticeJobServlet extends SlingAllMethodsServlet {

    @Reference
    private JobManager jobManager;

    private final Logger logger =LoggerFactory.getLogger(getClass());

    @Override
    protected void doGet(final SlingHttpServletRequest req,
       final SlingHttpServletResponse resp) throws IOException{

        final Map<String ,Object> props=new HashMap<>();
        props.put("data", "test");
        jobManager.addJob("practice/job", props);

        logger.error("Practice Servlet Called **********");

        resp.setStatus(SlingHttpServletResponse.SC_OK);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print("{\"response_message\":\"Servlet Called\"}");

       }
}
    