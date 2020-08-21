package com.kodcu.boot;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional(Transactional.TxType.REQUIRED)
public class EmergencyRoom {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Doctor doctor) {
        entityManager.merge(doctor);
    }

    public List<Doctor> getDoctorList() {
        return entityManager.
                createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
    }

    public String name;


}
