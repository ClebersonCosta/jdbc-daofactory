package com.algaworks.curso.dao;

import com.algaworks.curso.model.Cliente;

import java.util.List;

public interface ClienteDAO {

    public void salvar(Cliente cliente);
    public Cliente buscarPeloCodigo(Long codigo);
    public List<Cliente> buscarTodos();
}
