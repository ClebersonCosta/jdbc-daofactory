package com.algaworks.curso.dao;

public class DAOException extends RuntimeException {

    public DAOException(String s, Throwable t) {
        super(s, t);
    }
}
