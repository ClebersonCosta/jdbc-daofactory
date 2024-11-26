package com.algaworks;

import com.algaworks.curso.dao.ClienteDAO;
import com.algaworks.curso.dao.DAOFactory;
import com.algaworks.curso.model.Cliente;

import javax.swing.*;

public class SalvarCliente {
    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        Cliente cliente = new Cliente();

        String nome = JOptionPane.showInputDialog(null, "Nome do Cliente: ", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE);

        if (nome != null) {
            cliente.setNome(nome);

            ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
            clienteDAO.salvar(cliente);
            System.out.println("Cliente salvo com sucesso.");
        }
    }
}