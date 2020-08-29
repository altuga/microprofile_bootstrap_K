package com.kodcu.boot;

import javax.ejb.Stateful;
import javax.inject.Inject;


public class MRMachine {

    private String patientName;

    @Inject
    public MRMachine(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "MRMachine{" +
                "patientName='" + patientName + '\'' +
                '}';
    }
}
