package org.example.demo.ticket.consumer.Impl.dao;

import org.example.demo.ticket.consumer.contract.dao.TicketDao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public class TicketDaoImpl extends AbstractDaoImpl implements TicketDao {

    @Inject
    @Named("dataSourceTicket")
    private DataSource dataSource;
    protected DataSource getDataSource() {
        return dataSource;
    }
}
