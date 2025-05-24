package org.example3;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiKeyProperties {
    private static final String API_Key = "1234";

    public String getAPI_Key(){
        return API_Key;
    }
}
