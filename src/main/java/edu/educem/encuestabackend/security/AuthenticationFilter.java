package edu.educem.encuestabackend.security;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.educem.encuestabackend.models.requests.UserLoginRequestModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            UserLoginRequestModel userModel = new ObjectMapper().readValue(request.getInputStream(),
                    UserLoginRequestModel.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userModel.getEmail(),
                    userModel.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
            throws IOException,ServletException {
                String encodedString = Base64.getEncoder().encodeToString(SecurityConstants.getTokenSecret().getBytes());
                String email = ((User) authentication.getPrincipal()).getUsername();
                String token = Jwts.builder().setSubject(email).setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_DATE)).signWith(SignatureAlgorithm.HS512, encodedString).compact();
                Map.Entry<String, String> map = new AbstractMap.SimpleEntry<String, String>("token", SecurityConstants.TOKEN_PREFIX+token);
                String data = new ObjectMapper().writeValueAsString(map);    
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(data);
                response.flushBuffer();
    }
}
