package com.kodcu.boot;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class EmergencyRoom {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Doctor doctor) {
        entityManager.merge(doctor);
    }

    public String name;

    public EmergencyRoom(String name) {
        this.name = name;
    }
}
