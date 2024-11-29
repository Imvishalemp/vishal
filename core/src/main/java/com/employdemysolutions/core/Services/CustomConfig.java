package com.employdemysolutions.core.Services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
//>>>>>>>>>>>>>>> Osgi Congifugation >>>>>>>>>>>>>>>>>>>>
@ObjectClassDefinition(name="Custom Service Configuration" ,description="Simple Config")
public @interface CustomConfig {

    @AttributeDefinition(name="ChatBot pool id", description="simple Chatbot pool id" )
    String cbPoolId();

    @AttributeDefinition(name="ChatBot Region", description  ="Simple ChatBot Region")
    String cbRegion();

    @AttributeDefinition(name="ChatBot Name", description = "Simple Chatbot Name")
    String cbName();

}
