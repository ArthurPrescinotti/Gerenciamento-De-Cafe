package org.GerenciametoCafe.Estoque.Decorador;

import org.GerenciametoCafe.Estoque.Fabrica.Produto;

public class AcucarDecorador extends  ProdutoDecorador{

    private double precoAcucar = 1.5;

    public AcucarDecorador(Produto produto) {
        super(produto); //Passa o produto para o ProdutoDecorador
    }

    @Override
    public double calcularPreco() {
        return super.calcularPreco() + precoAcucar;
    }

    @Override
    public String getNome() {
        return super.getNome() + " com Acucar";
    }
}
