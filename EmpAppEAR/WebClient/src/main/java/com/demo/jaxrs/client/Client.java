package com.demo.jaxrs.client;

import com.demo.ejb.EmpApp;
import com.demo.ejb.EmpExistsException;
import com.demo.jpa.entity.Emp;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("client")
public class Client {

    //@EJB
    //@Inject
    // EmpApp app;

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerEmp(Emp e) {
        Response response = null;
        try {
            InitialContext ctx = new InitialContext();
            EmpApp app = (EmpApp) ctx.lookup("com.demo.ejb.EmpApp");
            String resp = app.save(e.getEmpId(), e.getName(), e.getCity(), e.getSalary());
            response = Response.ok(resp).build();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (EmpExistsException ex) {
           // ex.printStackTrace();
            response=Response.ok(ex.getMessage()).build();
        }
        return response;
    }
}
