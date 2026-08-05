package com.itb.in2em.pizzarianapoli.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

  // Utilize "?" ou "Object" quando o retorno pode ser objetos diferentes

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable String id) {
     try {
      Long idLong = Long.parseLong(id);
      Produto produto = produtoService.buscarPorId(idLong);
      if(produto == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto como o id " + id + " não encontrado.");
      }
        return ResponseEntity.ok(produto);
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( id + " inválido, utilize um valor numérico.");
     }
    
  }

  // Salvar Produto

  @PostMapping
  public ResponseEntity<Produto> save(@RequestBody Produto produto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(produto));
  }

  // Atualizar todos os dados do Produto

  @PutMapping("/{id}")
  public ResponseEntity<?> update (@PathVariable String id, @RequestBody Produto produto) {

   try {
      Long idLong = Long.parseLong(id);
      Produto produtoBanco = produtoService.buscarPorId(idLong);
      if(produtoBanco == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto como o id " + id + " não encontrado.");
      }
    
      Produto produtoAtualizado = produtoService.atualizar(idLong, produto);
      return ResponseEntity.ok(produtoAtualizado);
   } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( id + " inválido, utilize um valor numérico.");
   }

  }
  // Excluir Produto

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable String id) {
   try {

       Long idLong = Long.parseLong(id);
       Produto produtoBanco = produtoService.buscarPorId(idLong);
       if(produtoBanco == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto como o id " + id + " não encontrado.");
      }
      boolean excluido = produtoService.excluir(idLong);
      if (excluido) {
        return ResponseEntity.ok("Produto com o id " + id + " excluído com sucesso.");
      } else {
        return ResponseEntity.ok("Não foi possível excluir o produto com o id " + id);
      }
       
     } catch (Exception e) {
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( id + " inválido, utilize um valor numérico.");
    }
  }


}
