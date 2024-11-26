package com.algaworks;

import com.algaworks.curso.dao.ClienteDAO;
import com.algaworks.curso.dao.DAOFactory;
import com.algaworks.curso.model.Cliente;

import java.util.List;

public class BuscarTodos {
    public static void main (String args[]) {

        ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();

        List<Cliente> clientes = clienteDAO.buscarTodos();

        for (Cliente cliente : clientes) {
            if (cliente != null) {
                System.out.println("---------- Cliente ----------");
                System.out.printf("Código: %d\n", cliente.getCodigo());
                System.out.printf("Nome: %s\n", cliente.getNome());
                System.out.println();
            } else {
                System.out.println("Cliente não encontrado.");
            }
        }

    }

}
