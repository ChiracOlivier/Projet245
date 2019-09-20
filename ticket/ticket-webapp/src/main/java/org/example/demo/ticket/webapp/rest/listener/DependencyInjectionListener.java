package org.example.demo.ticket.webapp.rest.listener;

import org.example.demo.ticket.business.manager.impl.ManagerFactory;
import org.example.demo.ticket.business.manager.impl.manager.ProjetManagerImpl;
import org.example.demo.ticket.business.manager.impl.manager.TicketManagerImpl;
import org.example.demo.ticket.webapp.rest.resource.ticket.AbstractResource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyInjectionListener implements ServletContextListener {

    @Override
    public void contextInitialized (ServletContextEvent sce){
        //Creétaion de l'instance de ManagerFactory
        ManagerFactory vManagerFactory = new ManagerFactory();

        //On ajoute l'injection des dépencdances Manager dans la ManagerFactory
        vManagerFactory.setProjetManager(new ProjetManagerImpl());
        vManagerFactory.setTicketManager(new TicketManagerImpl());

        //Injection de l'instance de ManagerFactory dans la classe AbstractResource
        AbstractResource.setManagerFactory(vManagerFactory);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){

    }
}
