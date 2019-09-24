package org.example.demo.ticket.business.manager.impl.manager;

import org.example.demo.ticket.business.manager.contract.manager.TicketManager;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.ticket.*;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Manager des beans du package Ticket.
 *
 * @author lgu
 */

public class TicketManagerImpl implements TicketManager {



        @Override
        public Ticket getTicket(Long pNumero) throws NotFoundException {
            // Je n'ai pas encore codé la DAO
            // Je mets juste un code temporaire pour commencer le cours...
            if (pNumero < 1L) {
                throw new NotFoundException("Ticket non trouvé : numero=" + pNumero);
            }
            Evolution vEvolution = new Evolution(pNumero);
            vEvolution.setPriorite(10);
            return vEvolution;
        }


        @Override
        public List<Ticket> getListTicket(RechercheTicket pRechercheTicket) {
            // Je n'ai pas encore codé la DAO
            // Je mets juste un code temporaire pour commencer le cours...
            List<Ticket> vList = new ArrayList<>();
            if (pRechercheTicket.getProjetId() != null) {
                Projet vProjet = new Projet(pRechercheTicket.getProjetId());
                for (int vI = 0; vI < 4; vI++) {
                    Ticket vTicket = new Bug((long) pRechercheTicket.getProjetId() * 10 + vI);
                    vTicket.setProjet(vProjet);
                    vList.add(vTicket);
                }
            } else {
                for (int vI = 0; vI < 9; vI++) {
                    Ticket vTicket = new Evolution((long) vI);
                    vList.add(vTicket);
                }
            }
            return vList;
        }


        @Override
        public int getCountTicket(RechercheTicket pRechercheTicket) {
            // Je n'ai pas encore codé la DAO
            // Je mets juste un code temporaire pour commencer le cours...
            return 42;
        }
    @Inject
    @Named("txManagerTicket")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void changerStatut(Ticket pTicket, TicketStatut pNewStatut,
                              Utilisateur pUtilisateur, Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate
                = new TransactionTemplate(platformTransactionManager);

        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus
                                                                pTransactionStatus) {
                pTicket.setStatut(pNewStatut);
                getDaoFactory().getTicketDao().updateTicket(pTicket);
                // TODO Ajout de la ligne d'historique + commentaire ...
            }
        });
    }
    }


