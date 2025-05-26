package org.example3;

import org.springframework.context.annotation.Configuration;

@Configuration   //Marks the class as a configuration class
public class ApiKeyProperties {
    //Hardcoded API kye, used only for development not in real life scenario
    //For real life this would be placed in application.properties
    private static final String API_Key = "1234";

    //Getter for the API key
    public String getAPI_Key(){
        return API_Key;
    }
}
