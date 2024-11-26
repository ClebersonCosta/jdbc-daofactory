package com.algaworks.curso.dao;

public abstract class DAOFactory {

    public static DAOFactory getDAOFactory() {
        return new JdbcDAOFactory();
    }

    public abstract ClienteDAO getClienteDAO();
}
