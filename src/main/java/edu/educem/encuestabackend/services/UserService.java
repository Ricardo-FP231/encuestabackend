package edu.educem.encuestabackend.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import edu.educem.encuestabackend.entities.UserEntity;
import edu.educem.encuestabackend.models.requests.UserRegisterRequestModel;

public interface UserService  extends UserDetailsService{
    
    public UserDetails loadUserByUsername(String email);
    public UserEntity createUser(UserRegisterRequestModel user);
    public UserEntity getUser(String email);
}
