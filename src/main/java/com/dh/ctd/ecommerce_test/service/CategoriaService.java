package com.dh.ctd.ecommerce_test.service;

import com.dh.ctd.ecommerce_test.model.Categoria;
import com.dh.ctd.ecommerce_test.resources.IDao;

import java.util.List;
import java.util.Optional;

public class CategoriaService {

    private IDao<Categoria> categoriaIDao;

    public CategoriaService(IDao<Categoria> categoriaIDao) {
        this.categoriaIDao = categoriaIDao;
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaIDao.salvar(categoria);
    }

    public Optional<Categoria> buscar(Integer id) {
        return categoriaIDao.buscar(id);
    }

    public List<Categoria> buscarTodos() {
        return categoriaIDao.buscarTodos();
    }

    public void excluir(Integer id) {
        categoriaIDao.excluir(id);
    }

    public Categoria atualizar(Categoria categoria) {
        return categoriaIDao.atualizar(categoria);
    }

}
