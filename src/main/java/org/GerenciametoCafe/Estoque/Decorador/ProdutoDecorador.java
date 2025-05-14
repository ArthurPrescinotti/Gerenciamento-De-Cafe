package org.GerenciametoCafe.Estoque.Decorador;

import org.GerenciametoCafe.Estoque.Fabrica.Produto;

public abstract class ProdutoDecorador extends Produto {
    protected Produto produto;

    public ProdutoDecorador(Produto produto){
        this.produto = produto;
    }

    @Override
    public double calcularPreco() {
        return produto.calcularPreco();
    }

    @Override
    public String getNome() {
        return produto.getNome();
    }
}
