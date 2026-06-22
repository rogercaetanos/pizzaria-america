package com.itb.in2em.pizzarianapoli.model.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.itb.in2em.pizzarianapoli.model.entity.Produto;

public class ProdutoService {

    // Lista temporária de Produtos 

    private static List<Produto> PRODUTOS = new ArrayList<>();

   
    static {

        Produto p1 = new Produto();
        p1.setId(1L);
        p1.setNome("Pizza Calabresa");
        p1.setValorVenda(BigDecimal.valueOf(45.90));

        Produto p2 = new Produto();
        p2.setId(2L);
        p2.setNome("Pizza Portuguesa");
        p2.setValorVenda(BigDecimal.valueOf(52.90));

        PRODUTOS.add(p1);
        PRODUTOS.add(p2);
    }

    // CREATE
    public Produto salvar(Produto produto) {

        Long novoId = gerarNovoId();
        produto.setId(novoId);

        PRODUTOS.add(produto);

        return produto;
    }

    // READ - listar todos
    public List<Produto> listarTodos() {
        return PRODUTOS;
    }

    // READ - buscar por id
    public Produto buscarPorId(Long id) {

        for (Produto produto : PRODUTOS) {

            if (produto.getId().equals(id)) {
                return produto;
            }
        }

        return null;
    }

    // UPDATE
    public Produto atualizar(Long id, Produto produtoAtualizado) {

        Produto produto = buscarPorId(id);

        if (produto != null) {

            produto.setNome(produtoAtualizado.getNome());
            produto.setValorVenda(produtoAtualizado.getValorVenda());

            return produto;
        }

        return null;
    }

    // DELETE
    public boolean excluir(Long id) {

        Produto produto = buscarPorId(id);

        if (produto != null) {
            PRODUTOS.remove(produto);
            return true;
        }

        return false;
    }

    // Gera ID automático
    private Long gerarNovoId() {

        Long maiorId = 0L;

        for (Produto produto : PRODUTOS) {

            if (produto.getId() > maiorId) {
                maiorId = produto.getId();
            }
        }

        return maiorId + 1;
    }



}
