package edu.educem.encuestabackend.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.educem.encuestabackend.entities.UserEntity;
import edu.educem.encuestabackend.models.requests.UserRegisterRequestModel;
import edu.educem.encuestabackend.models.responses.UserRest;
import edu.educem.encuestabackend.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public UserRest createUser(@RequestBody @Valid UserRegisterRequestModel userModel) {
        UserEntity user = userService.createUser(userModel);

        UserRest userRest = new UserRest();
        BeanUtils.copyProperties(user, userRest);

        return userRest;
    }

    @GetMapping
    public UserRest getMethodName(Authentication authentication) {
        UserEntity user = userService.getUser(authentication.getPrincipal().toString());
        UserRest userRest = new UserRest();
        BeanUtils.copyProperties(user, userRest);
        return userRest;
    }

}
