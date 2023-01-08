package com.sidsolutions.app;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/hello")
public class Hello {
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response greet() {
        return Response.ok("Hello World!!!").build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response greet(@PathParam("name") String name) {
        return Response.ok("Hello "+name+"!!!").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public Response createCustomer(@FormParam("name") String name, @FormParam("password") String password) {
        if (password.equals("Please"))
            return Response.ok("Hello "+name+"!!!").build();
        else
            return Response.status(Status.UNAUTHORIZED).build();
    }
}