package edu.educem.encuestabackend.security;

import edu.educem.encuestabackend.SpringApplicationContext;

public class SecurityConstants {
    
    public static final long EXPIRATION_DATE = 864000000;
    public static final String LOGIN_URL = "/users/login";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static String getTokenSecret(){
        ApplicationProperties applicationProperties = (ApplicationProperties) SpringApplicationContext.getBean("AppProperties");
        return applicationProperties.getTokenSecret();
    }

}
