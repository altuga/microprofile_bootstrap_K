package com.kodcu.boot;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class LogManager {

    @Produces
    public Logger configure(InjectionPoint injectionPoint) {
        String name = injectionPoint.getMember().getName();
        return Logger.getLogger(name) ;
    }

}
