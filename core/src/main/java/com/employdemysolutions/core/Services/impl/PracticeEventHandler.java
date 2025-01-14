package com.employdemysolutions.core.Services.impl;


import java.nio.file.Path;

import org.apache.sling.api.SlingConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//example for the event Handler
@Component(service=EventHandler.class,
immediate = true,
property = {
EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/*",
SlingConstants.PROPERTY_PATH + "=/content/employdemy-solutions/NewPageTemaplate"
})
public class PracticeEventHandler implements EventHandler {
    
private final Logger logger = LoggerFactory.getLogger(getClass());

@Override
public void handleEvent (Event event) {
    //every log type will be can be seen in custom error log 
    //we have to create the log by specifing the  package name
logger.error("Event Topic = {} <<<<<<<<<<<<<<<<<<<<<<<<<<<<<, Path = {} >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", event.getTopic(),
event.getProperty(SlingConstants.PROPERTY_PATH));
logger.info("this msg back from #######################################");
logger.error("this msg back from *****************************************");

}
}