package org.example.demo.ticket.webapp.rest.resource.ticket;

import org.example.demo.ticket.business.manager.impl.ManagerFactory;

public abstract class AbstractResource {

    private static ManagerFactory managerFactory;

    protected static  ManagerFactory getManagerFactory(){
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactory pManagerFactory){
        managerFactory=pManagerFactory;
    }

}
