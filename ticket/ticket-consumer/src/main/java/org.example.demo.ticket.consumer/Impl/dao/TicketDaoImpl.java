package org.example.demo.ticket.consumer.Impl.dao;

import org.example.demo.ticket.consumer.contract.dao.TicketDao;


public class TicketDaoImpl extends AbstractDaoImpl implements TicketDao {

    @Override
    public int getCountTicket(RechercheTicket pRechercheTicket) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrTicket = vJdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM ticket",
                Integer.class);

        return vNbrTicket;
    }
}
