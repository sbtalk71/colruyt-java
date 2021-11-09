package com.demo.spring;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("app")
public class DemoController {
    @RequestMapping(path="mypage",method = RequestMethod.GET)
    public String getPage(){
        return "securepage";
    }
    @RequestMapping(path="adminpage",method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String getAdminPage(){
        return "admin";
    }
}
