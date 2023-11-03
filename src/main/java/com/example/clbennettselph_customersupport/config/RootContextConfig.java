package com.example.clbennettselph_customersupport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "com.example.clbennettselph_customersupport.site", excludeFilters = @ComponentScan.Filter(Controller.class))

public class RootContextConfig {

}
