package com.demo.spring.controllers;

import com.demo.spring.controllers.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginPage(ModelMap modelMap) {
        User user=new User();
        modelMap.addAttribute("user",user);
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

    @RequestMapping(path="process", method = RequestMethod.POST)
    public ModelAndView processLogin(@ModelAttribute("user") User user){
        ModelAndView mv= new ModelAndView();
        if(user.getUserName().equals(user.getPassword())){
            mv.setViewName("success");
            mv.addObject("user",user);
        }else{
            mv.setViewName("failure");
        }
        return mv;
    }

}
