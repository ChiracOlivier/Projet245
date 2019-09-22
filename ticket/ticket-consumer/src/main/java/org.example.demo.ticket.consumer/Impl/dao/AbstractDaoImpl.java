package org.example.demo.ticket.consumer.Impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {
    @Inject
    @Named("dataSourceTicket")
    private DataSource dataSource;
    protected DataSource getDataSource() {
        return dataSource;
    }
}
