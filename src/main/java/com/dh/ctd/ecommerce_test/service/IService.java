package com.dh.ctd.ecommerce_test.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    List<T> buscarTodos();
    Optional<T> buscar(Integer id);
    void salvar(T t);
    // void atualizar(T t);
    void excluir(Integer id);

}
