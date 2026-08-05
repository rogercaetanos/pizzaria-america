package com.itb.in2em.pizzarianapoli.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

// A seguir annotation do (Spring Web MVC) dependência: "spring-boot-starter-webmvc" (pom.xml)

// Annotation de classe

// @Controller: Sistema Web ( Sites em geral) - Back-End + Front-End
// @RestController: Api (apenas api´s) - Apenas Back-End

// Annotation de métodos

// @GetMapping:  Utilizado para "buscar" dados na API (Somente pesquisa)
// @PostMapping: Utilizado para "enviar" dados para API (Cadastros)
// @PutMapping:  Utilizado para "atualizar" todos os dados na API
// @DeleteMapping: Utilizado para "excluir" dados na API
// @PatchMapping: Utilizado para "atualizar parcialmente" dados na API, exemplo: mudar o status de um produto

// ResponseEntity: Controla a resposta HTTP completa de uma API, permitindo definir o corpo (body), o código de status (200, 201, 400 etc.)
//                 e os cabeçalhos (headers)


@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

  // Ligação com o service

  private ProdutoService produtoService = new ProdutoService();


  // Listando todos os produtos

  @GetMapping
  public ResponseEntity  <List<Produto>> findAll() {
    return   ResponseEntity.ok(produtoService.listarTodos());
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
