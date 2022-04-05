package com.dh.ctd.ecommerce_test.repository;

import com.dh.ctd.ecommerce_test.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
