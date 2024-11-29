package com.employdemysolutions.core.Services.impl;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import com.employdemysolutions.core.Services.CustomConfig;
import com.employdemysolutions.core.Services.CustomConfigService;

@Component(immediate = true)
@Designate(ocd = CustomConfig.class)
public class CustomConfigImpl implements CustomConfigService {

    private String cbPoolId;
    private String cbRegion;
    private String cbName;

    @Activate
    @Modified
    protected void activate(CustomConfig config) {
        this.cbPoolId = config.cbPoolId();
        this.cbRegion = config.cbRegion();
        this.cbName = config.cbName();
    }

  
    @Override
    public String getChatbotDetails() {
        return String.format("Pool ID: %s, Region: %s, Bot Name: %s", cbPoolId, cbRegion, cbName);
    }
}

