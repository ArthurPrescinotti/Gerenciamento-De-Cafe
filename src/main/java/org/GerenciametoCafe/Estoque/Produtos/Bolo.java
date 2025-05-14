package org.GerenciametoCafe.Estoque.Produtos;

import org.GerenciametoCafe.Estoque.Fabrica.Produto;

public class Bolo extends Produto {

    private String nome;
    private Double preco;
    private String complemento;

    public Bolo (String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + " Preço: R$" + this.preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    @Override
    public double calcularPreco() {
        return preco;
    }
}
