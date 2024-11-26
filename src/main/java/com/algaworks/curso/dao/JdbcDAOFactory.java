package com.algaworks.curso.dao;

import com.algaworks.curso.dao.jdbc.JdbcClienteDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDAOFactory extends DAOFactory {

    private Connection connection;

    public JdbcDAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/algaworks", "root", "");
        } catch (Exception e) 
            throw new RuntimeException("Erro ao recuperar a conexão com o banco", e);
        }
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new JdbcClienteDAO(connection);
    }
}
