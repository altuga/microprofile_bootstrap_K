package com.kodcu.boot;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class StringManager {

    @Produces
    public String configure(InjectionPoint injectionPoint) {
        return injectionPoint.getMember().getDeclaringClass().getSimpleName();
    }

}
