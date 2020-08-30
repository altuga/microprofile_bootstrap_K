package com.kodcu.boot;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;


public class CleaningService {

    @Inject
    @ConfigProperty(name = "value", defaultValue = "Camasir Suyu")
    String value;

    @Fallback(fallbackMethod = "findExtraCleaningPerson")
    @Retry(maxRetries = 2)
    public void start() {
        System.out.println("--cleaning process will start soon with  " + this.value);
        throw new IllegalStateException("Cleaning person is not available today");
    }

    public void findExtraCleaningPerson() {
        System.out.println("--- finding extra cleaning person");
    }
}
