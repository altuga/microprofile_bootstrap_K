package com.kodcu.boot;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Interceptors(CallTracer.class)
@Path("/hello")
@Singleton
public class HospitalContoller {

    @Inject
    Doctor doctor;

    @GET
    public String sayHello() {
        //return "Hello my Hospital 123 ";
        return doctor.sayHello();
    }

    @GET
    @Path("/bye")
    public String sayGoodBye() {
        return "Good Bye ";

    }
}
