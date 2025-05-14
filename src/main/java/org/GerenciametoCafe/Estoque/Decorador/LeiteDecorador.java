package org.GerenciametoCafe.Estoque.Decorador;

import org.GerenciametoCafe.Estoque.Fabrica.Produto;

public class LeiteDecorador extends ProdutoDecorador{

    private double precoLeite = 2.50;

    public LeiteDecorador(Produto produto) {
        super(produto);  //Passa o produto para o ProdutoDecorador
    }

    @Override
    public double calcularPreco() {
        return super.calcularPreco() + precoLeite;
    }

    @Override
    public String getNome() {
        return super.getNome() + " com Leite";
    }
}

