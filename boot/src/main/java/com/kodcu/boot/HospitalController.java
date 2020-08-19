package com.kodcu.boot;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 */
@Interceptors(CallTracer.class)
@Path("/hello")
@Singleton
@Produces( "application/json" )
public class HospitalController {

    @Inject
    Doctor doctor;

    @Inject
    EmergencyRoom emergencyRoom;

    @GET
    public String sayHello() {
        emergencyRoom.save(doctor);
        return doctor.getClass().getName();
    }



    @GET
    @Path("/bye")
    public String sayGoodBye() {
        return "Good Bye ";

    }
}
