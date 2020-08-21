package com.kodcu.boot;

import java.util.Set;

public class MyEntityManager {

    private Set<Object> freshlyCreated;

    public void persist(Object object) {
        freshlyCreated.add(object) ;
    }

    public Object merge(Object object) {

        Object copy =  null; ,
        //copy = object.clone();
        freshlyCreated.add(copy);
        return copy;
    }

}
