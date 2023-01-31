package com.nikhil.containers.dockerresearch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ContainerAppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/static/json-files/")
                .addResourceLocations("classpath:/static/notes/")
                .addResourceLocations("src/main/resources/static/json-files")
        .addResourceLocations("/Users/nikhilhiremath/Documents/Engineering/CKAD/Docker/apps/12-30/docker-research/src/main/resources/static/json-files");
    }
}
