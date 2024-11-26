package com.algaworks.curso.dao.jdbc;

import com.algaworks.curso.dao.ClienteDAO;
import com.algaworks.curso.dao.DAOException;
import com.algaworks.curso.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcClienteDAO implements ClienteDAO {

    private Connection connection;

    public JdbcClienteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvar(Cliente cliente) {

        try {
            String sql = String.format("insert into cliente (nome) values ('%s')", cliente.getNome());

            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {

            throw new DAOException("Erro ao salvar o cliente", e);

        } finally {

            try {
                this.connection.close();
            } catch (SQLException e) {}
        }
    }

    @Override
    public Cliente buscarPeloCodigo(Long codigo) {
        Cliente cliente = null;

        try {
            String sql = String.format("select * from cliente where codigo = %d", codigo);

            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getLong("codigo"));
                cliente.setNome(rs.getString("nome"));
            }

        } catch (SQLException e) {

            throw new DAOException("Erro ao consultar o cliente", e);

        } finally {

            try {
                this.connection.close();
            } catch (SQLException e) {}
        }

        return cliente;
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente;

        try {
            String sql = "select * from cliente";

            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getLong("codigo"));
                cliente.setNome(rs.getString("nome"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {

            throw new DAOException("Erro ao consultar todos os clientes", e);

        } finally {

            try {
                this.connection.close();
            } catch (SQLException e) {}
        }

        return clientes;
    }
}
