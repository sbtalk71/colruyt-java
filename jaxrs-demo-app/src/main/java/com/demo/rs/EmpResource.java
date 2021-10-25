package com.demo.rs;

import com.demo.rs.db.EmpDb;
import com.demo.rs.entity.Emp;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("emp")
public class EmpResource {

    @Inject
    EmpDb empDb;
    public EmpResource() {
        System.out.println("Emp Resource created..");
    }

    @Path("find/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getEmpById(@PathParam("id") int empId) {
        if (EmpDb.getDb().containsKey(empId)) {
            Emp emp = empDb.getDb().get(empId);
            return Response.ok(emp).build();
        } else {
            return Response.ok("{\"Status\":\"Emp Not Found\"}").build();
        }
    }

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addEmp(Emp e) {
        if (empDb.getDb().containsKey(e.getEmpId())) {
            return Response.ok("Emp already exists with id " + e.getEmpId()).build();
        } else {
            empDb.getDb().put(e.getEmpId(), e);
            return Response.ok("Emp saved successfully with id " + e.getEmpId()).build();
        }
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateEmp(Emp e) {
        if (empDb.getDb().containsKey(e.getEmpId())) {
            empDb.getDb().put(e.getEmpId(), e);
            return Response.ok("Emp Updated successfully with id " + e.getEmpId()).build();
        } else {
            return Response.ok("Emp Not Found..").build();
        }
    }


    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() {
        List<Emp> empList = new ArrayList(empDb.getDb().values());
        return Response.ok(empList).build();
    }


    //DELETE http://localhost:9080/jaxrs-1.0/emp/delete?id=104
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletEmp(@QueryParam("id") int empId) {
        if (empDb.getDb().containsKey(empId)) {
            empDb.getDb().remove(empId);
            return Response.ok("Emp Deleted").build();
        }else{
            return Response.ok("Emp Not Found").build();
        }
    }

}
