package com.itb.in2em.pizzarianapoli.model.services;

import java.util.ArrayList;
import java.util.List;

import com.itb.in2em.pizzarianapoli.model.entity.Produto;

public class ProdutoService {

    // Lista temporária de Produtos 

    private static List<Produto> PRODUTOS = new ArrayList<>();

    static {

        PRODUTOS.add(null );
    }

}
