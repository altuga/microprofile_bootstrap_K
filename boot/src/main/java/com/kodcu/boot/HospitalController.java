package com.kodcu.boot;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

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
        doctor.name = "Ahmet";
        doctor.surname = "Er";
        return doctor.getClass().getName();
    }

    @GET
    @Path("doctors")
    @Counted(name = "list_of_doctors")
    public List<Doctor> getDoctorListinER() {
        return emergencyRoom.getDoctorList();
    }

    @POST
    @Path("savedoc")
    @Metered
    public void saveDoctor(Doctor doctor) {
        emergencyRoom.save(doctor);

    }



    @GET
    @Path("/bye")
    public String sayGoodBye() {
        return "Good Bye ";

    }
}
