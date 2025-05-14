package org.GerenciametoCafe.Estoque.Fabrica;

import org.GerenciametoCafe.Estoque.Produtos.Bolo;
import org.GerenciametoCafe.Estoque.Produtos.Suco;

public class Factory {

    public static Produto criarBolo(String nome, Double preco){
        return new Bolo(nome, preco);
    }

    public static Produto criarSuco(String nome, Double preco){
        return new Suco(nome, preco);
    }

    public static Produto criarCafe(String nome, Double preco){
        return new Suco(nome, preco);
    }

}
