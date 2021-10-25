package com.demo.rs;

import com.demo.rs.db.EmpDb;
import com.demo.rs.entity.Emp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("emp")
public class EmpResource {

    EmpDb empDb;

    @Path("find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmpById(@PathParam("id") int empId){
        if(EmpDb.getDb().containsKey(empId)){
            Emp emp = EmpDb.getDb().get(empId);
            return Response.ok(emp).build();
        }else{
            return Response.ok("{\"Status\":\"Emp Not Found\"}").build();
        }
    }
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList(){
        List<Emp> empList=new ArrayList(EmpDb.getDb().values());
        return Response.ok(empList).build();
    }


}
