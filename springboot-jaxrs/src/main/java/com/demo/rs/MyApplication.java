package com.demo.rs;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@Component
@ApplicationPath("/services/*")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(EmpResource.class);
    }
}
