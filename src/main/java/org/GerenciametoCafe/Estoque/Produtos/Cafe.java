package org.GerenciametoCafe.Estoque.Produtos;

import org.GerenciametoCafe.Estoque.Fabrica.Produto;

public class Cafe extends Produto {
    public String nome;
    public Double preco;
    public String complemento;

    public Cafe(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Nome:'" + this.nome + " Preco: R$" + this.preco;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
