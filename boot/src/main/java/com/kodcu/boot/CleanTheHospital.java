package com.kodcu.boot;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Startup
@Singleton
public class CleanTheHospital {

    private Map<String, String> cache;

    @PostConstruct
    public void init() {
        this.cache = new ConcurrentHashMap<>();
        System.out.println("initialized at the very beginning!");
    }

    @Schedule(second = "*/1", minute = "*", hour = "*", persistent=false)
    public void refreshCache() {
        System.out.println("--- " + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CleanTheHospital.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Woke up!");
    }

}
