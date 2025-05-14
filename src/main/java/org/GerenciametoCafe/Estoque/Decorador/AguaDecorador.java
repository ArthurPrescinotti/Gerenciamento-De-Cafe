package org.GerenciametoCafe.Estoque.Decorador;

import org.GerenciametoCafe.Estoque.Fabrica.Produto;

public class AguaDecorador extends ProdutoDecorador{

    private double precoAgua = 1.00;
    public AguaDecorador(Produto produto) {
        super(produto); //Passa o produto para o ProdutoDecorador
    }

    @Override
    public double calcularPreco() {
        return super.calcularPreco() + precoAgua;
    }

    @Override
    public String getNome() {
        return super.getNome() + " com Agua Quente";
    }
}
