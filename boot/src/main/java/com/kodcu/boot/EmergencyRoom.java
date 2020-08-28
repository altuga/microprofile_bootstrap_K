package com.kodcu.boot;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;
@Transactional(Transactional.TxType.REQUIRED)
public class EmergencyRoom {

    @Inject
    Logger logger;

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Event<Doctor> listeners;

    @Inject
    Doesntmatter doesntmatter;


    public void save(Doctor doctor) {
        listeners.fire(doctor) ;
        entityManager.persist(doctor);
        logger.warning("log doctor name  --> " + doctor.name);

        doesntmatter.save();
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
