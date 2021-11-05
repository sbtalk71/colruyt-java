package com.demo.spring.controllers;

import com.demo.spring.controllers.model.User;
import com.demo.spring.repo.UserRepository;
import com.demo.spring.validators.UserFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private UserFieldValidator validator;

    @Autowired
    UserRepository repo;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginPage(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "login";
    }

    /*@RequestMapping(path="process", method = RequestMethod.POST)
    public ModelAndView processLogin(@RequestParam("userName") String user, @RequestParam("password") String pwd){
        ModelAndView mv= new ModelAndView();
        if(user.equals(pwd)){
            mv.setViewName("success");
            mv.addObject("user",user);
        }else{
            mv.setViewName("failure");
        }
        return mv;
    }*/

    @RequestMapping(path = "process", method = RequestMethod.POST)
    public ModelAndView processLogin(@ModelAttribute("user") User user, BindingResult errors) {
        ModelAndView mv = new ModelAndView();
        validator.validate(user, errors);
        if (errors.hasErrors()) {
            mv.setViewName("login");
        } else {
            Optional<User> userOpt = repo.findById(user.getUserName());
            if (userOpt.isPresent()) {
                User u1 = userOpt.get();
                if (u1.getPassword().equals(user.getPassword())) {
                    mv.setViewName("success");
                    mv.addObject("user", user);
                } else {
                    mv.setViewName("failure");
                }
            } else {
                mv.setViewName("failure");
            }
        }
        return mv;
    }

}
