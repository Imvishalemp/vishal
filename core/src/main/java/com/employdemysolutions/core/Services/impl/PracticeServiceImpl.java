package com.employdemysolutions.core.Services.impl;

import org.osgi.service.component.annotations.Component;

import com.employdemysolutions.core.Services.PracticeService;

@Component(service = PracticeService.class)
public class PracticeServiceImpl  implements PracticeService{

    @Override
    public String getName() {
        return "vishal from PracticeServiceImpl";
    }

}
