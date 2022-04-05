package com.dh.ctd.ecommerce_test.controller;

import com.dh.ctd.ecommerce_test.model.Categoria;
import com.dh.ctd.ecommerce_test.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<?> salvarCategoria(@RequestBody Categoria categoria) {
        categoriaService.salvar(categoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCategoria(@PathVariable Integer id) {
        categoriaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
