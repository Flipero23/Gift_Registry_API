package org.example3;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration    //Marks the class as a configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private ApiKeyInterceptor apiKeyInterceptor;

    //Constructor to inject the interceptor
    public WebMvcConfig(ApiKeyInterceptor apiKeyInterceptor) {
        this.apiKeyInterceptor = apiKeyInterceptor;
    }

    //Method to add the interceptors
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiKeyInterceptor).addPathPatterns("/registries/**", "/guests/**", "/items/**")  //Protects these endpoints
                .excludePathPatterns("/h2-console");   //Allows access to the H2 console without API key

    }
}
