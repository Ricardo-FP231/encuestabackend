package edu.educem.encuestabackend.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.educem.encuestabackend.annotations.UniqueEmail;
import edu.educem.encuestabackend.entities.UserEntity;
import edu.educem.encuestabackend.repositories.UserRepository;

public class UniqueEmailValidator  implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        UserEntity user = userRepository.findByEmail(value);

        if(user == null){
            return true;
        }
        return false;
    }
    
}
