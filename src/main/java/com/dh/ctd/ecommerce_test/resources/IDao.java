package com.dh.ctd.ecommerce_test.resources;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    public T salvar(T t);
    public Optional<T> buscar(Integer id);
    public List<T> buscarTodos();
    public void excluir(Integer id);
    public T atualizar(T t);

}
