package com.nsa.ons.onsgroupproject.config.routing;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  public void addViewControllers(ViewControllerRegistry registry) { registry.addViewController("/register").setViewName("register");

    registry.addViewController("/register").setViewName("register");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/403").setViewName("403");
    registry.addViewController("/reports").setViewName("forward:/reports/index.html");



  }

}
