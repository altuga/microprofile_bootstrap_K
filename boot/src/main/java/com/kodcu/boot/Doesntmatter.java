package com.kodcu.boot;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;

@Stateless
public class Doesntmatter {

    @Resource
    SessionContext sessionContext;

    public void save() {
        sessionContext.setRollbackOnly();
    }
}
