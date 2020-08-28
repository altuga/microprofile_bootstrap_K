package com.kodcu.boot;

import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

public class DoctorListener {

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry registry;

    public void onSuccessful(@Observes(during = TransactionPhase.AFTER_SUCCESS) Doctor doctor) {
        registry.counter("doctor_created").inc();
        System.out.println("++ " + doctor);
    }

    public void onFailed(@Observes(during = TransactionPhase.AFTER_FAILURE) Doctor doctor) {
        registry.counter("doctor_failed").inc();
        System.out.println("-----Tuh-- " + doctor);
    }

}