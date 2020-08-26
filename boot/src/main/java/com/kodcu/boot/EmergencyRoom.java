package com.kodcu.boot;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@Transactional(Transactional.TxType.REQUIRED)
public class EmergencyRoom {

    @Inject
    Logger logger;

    @PersistenceContext
    EntityManager entityManager;

    public void save(Doctor doctor) {
        entityManager.merge(doctor);
        logger.warning("log doctor name  --> " + doctor.name);

        //DB -->
        // entityManager.flush();
        // DB <--
        // entityManager.refresh(doctor);
        //
    }

    public List<Doctor> getDoctorList() {
        return entityManager.
                createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
    }

    public String name;


}
