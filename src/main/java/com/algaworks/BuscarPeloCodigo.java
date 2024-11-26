package com.algaworks;

import com.algaworks.curso.dao.ClienteDAO;
import com.algaworks.curso.dao.DAOFactory;
import com.algaworks.curso.model.Cliente;

public class BuscarPeloCodigo {
    public static void main (String arg[]) {

        ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();

        Cliente cliente = clienteDAO.buscarPeloCodigo(1L);

        if (cliente != null) {
            System.out.println("---------- Cliente encontrado ----------");
            System.out.printf("Código: %d\n", cliente.getCodigo());
            System.out.printf("Nome: %s\n", cliente.getNome());
            System.out.println();
        } else {
            System.out.println("Cliente não encontrado.");
        }

    }

}
