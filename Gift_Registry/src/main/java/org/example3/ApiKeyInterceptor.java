package org.example3;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component    //Marks the class as a component so it can be detected automatically by Spring
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static String API_KEY_HEADER = "X-API-KEY";   //Header name to look for
    private ApiKeyProperties apiKeyProperties;    //Inject properties class that contains the expected key

    public ApiKeyInterceptor(ApiKeyProperties apiKeyProperties) {
        this.apiKeyProperties = apiKeyProperties;
    }

    //Method that is called before the actual handler
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();   //GET,POST,PUT...
        String path = request.getRequestURI();   //Get the URI (example: '/registries')
        String apiKey = request.getHeader(API_KEY_HEADER);   //Get the API key from the header

        //Checks if the key is missing or invalid
        if (apiKey == null || !apiKey.equals(apiKeyProperties.getAPI_Key())) {
            System.out.println("Unsuccessful authorization for method: " + method + ", for path: " + path);

            response.setStatus(HttpStatus.UNAUTHORIZED.value());  //Sets the status to 401 - unauthorized
            response.getWriter().write("API key missing or invalid");   //Print out a message

            return false;   //Reject the request
        }


        //If the API key is valid the request is continued and a message is given
        System.out.println("Successful authorization for method: " + method + ", for path: " + path);
        return true;
    }

}


