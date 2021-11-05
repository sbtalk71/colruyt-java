package com.demo.spring.validators;

import com.demo.spring.controllers.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserFieldValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User u=(User)target;
        if(u.getUserName().length()==0){
            errors.rejectValue("userName","erros.invalid_id","User Name cannot be empty");
        }
        if(u.getPassword().length()==0){
            errors.rejectValue("password","erros.invalid_pwd","Password cannot be empty");
        }
    }
}
