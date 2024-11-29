package com.employdemysolutions.core.Services.impl;

import java.util.List;

import org.apache.sling.api.resource.observation.ResourceChange;
import org.apache.sling.api.resource.observation.ResourceChangeListener;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//
//****************This for thhe event Listener */
@Component(
    immediate = true,
    service = ResourceChangeListener.class,
    property = {
        ResourceChangeListener.PATHS+"=/content/employdemy-solutions/us",
        ResourceChangeListener.CHANGES+"=ADDED",
        ResourceChangeListener.CHANGES+"=REMOVED",
        ResourceChangeListener.CHANGES+"=CHANGED"
    }
)
public class ResourceEventHandler implements ResourceChangeListener {
   private static final  Logger log=LoggerFactory.getLogger(ResourceEventHandler.class);
   
    @Override
    public void onChange(List<ResourceChange> list) {
        log.info("inside method");

        for(ResourceChange rc : list)
        {
            log.info("/n Event : {}, Resource : {}*****************************" ,rc.getType(),rc.getPath());
            // log.info(rc.getPath()+"######################this is the Path#########################");
            log.debug("333333333333333333333333333333333333333333333333");
            log.info("1111111111111111111111111");
            log.error("Error Occured due to EVent Issue");
        }
    }

}
