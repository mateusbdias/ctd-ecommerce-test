package com.dh.ctd.ecommerce_test.service;

import com.dh.ctd.ecommerce_test.model.Produto;
import com.dh.ctd.ecommerce_test.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements IService<Produto> {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> buscar(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }
}
