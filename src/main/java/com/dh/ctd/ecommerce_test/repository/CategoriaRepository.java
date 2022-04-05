package com.dh.ctd.ecommerce_test.repository;

import com.dh.ctd.ecommerce_test.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
