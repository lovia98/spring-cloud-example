package com.example.clientapi.controller;

import com.example.clientapi.properties.BasicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamic")
@RefreshScope
public class FrontDynamicController {

    @Value("${host.domain}")
    private String serviceDomain;

    @Autowired
    private BasicConfig hostConfig;

    @RequestMapping("/")
    public String index() {
        return "My domain: "+ serviceDomain;
    }

    @RequestMapping("/hostInfo")
    public String hostInfo() {
        return "My domain: "+ hostConfig.getDomain();
    }
}
