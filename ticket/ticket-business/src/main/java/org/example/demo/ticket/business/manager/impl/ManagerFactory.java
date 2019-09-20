package org.example.demo.ticket.business.manager.impl;

import org.example.demo.ticket.business.manager.contract.manager.ProjetManager;
import org.example.demo.ticket.business.manager.contract.manager.TicketManager;

public class ManagerFactory {


    private ProjetManager projetManager;
    public ProjetManager getProjetManager(){
        return this.projetManager;
    }
    public void setProjetManager(ProjetManager projetManager) {
        this.projetManager = projetManager;
    }
    private TicketManager ticketManager;
    public void setTicketManager(TicketManager ticketManager) {
        this.ticketManager = ticketManager;
    }

    public TicketManager getTicketManager(){
        return this.ticketManager;
    }
}
