package com.example.User.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableWebMvc
@EnableSwagger2
@Component
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket (DocumentationType.SWAGGER_2)
                .apiInfo (apiInfo())
               .select ()
                .build ();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder ().title("User MicroService")
                .description("Sample Documentation Generateed Using SWAGGER2 for our User Rest API")
                .build();
    }
}
