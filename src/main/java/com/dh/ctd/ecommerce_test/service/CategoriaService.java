package com.dh.ctd.ecommerce_test.service;

import com.dh.ctd.ecommerce_test.model.Categoria;
import com.dh.ctd.ecommerce_test.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements IService<Categoria> {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> buscar(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void salvar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void excluir(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
