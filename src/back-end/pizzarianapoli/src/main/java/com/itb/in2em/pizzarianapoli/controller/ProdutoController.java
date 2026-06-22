package com.itb.in2em.pizzarianapoli.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itb.in2em.pizzarianapoli.model.entity.Produto;
import com.itb.in2em.pizzarianapoli.model.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

  // Ligação com o service

  private ProdutoService produtoService = new ProdutoService();


  // Listando todos os produtos

  @GetMapping
  public List<Produto> findAll() {
    return produtoService.listarTodos();
  }
  
  // Buscar produto pelo Id

  @GetMapping("/{id}")
  public Produto findById(@PathVariable Long id) {
    return produtoService.buscarPorId(id);
  }

  // Salvar Produto

  @PostMapping
  public Produto save(@RequestBody Produto produto) {
    return produtoService.salvar(produto);
  }

  // Atualizar todos os dados do Produto

  @PutMapping("/{id}")
  public Produto update (@PathVariable Long id, @RequestBody Produto produto) {

    return produtoService.atualizar(id, produto);

  }
  // Excluir Produto

  @DeleteMapping("/{id}")
  public boolean delete(@PathVariable Long id) {
    return produtoService.excluir(id);
  }


}
