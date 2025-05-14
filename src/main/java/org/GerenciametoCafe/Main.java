package org.GerenciametoCafe;

import org.GerenciametoCafe.Estoque.Decorador.AcucarDecorador;
import org.GerenciametoCafe.Estoque.Decorador.AguaDecorador;
import org.GerenciametoCafe.Estoque.Decorador.LeiteDecorador;
import org.GerenciametoCafe.Estoque.Fabrica.Factory;
import org.GerenciametoCafe.Estoque.Fabrica.Produto;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int EscolherPedido(){
        String Validacao = JOptionPane.showInputDialog(null, "1 - Bolo\n" +
                        "2 - Suco\n" + "3 - Cafe Preto",
                "Padaria da Esquina", JOptionPane.INFORMATION_MESSAGE);
        if(Validacao == null || Validacao.isEmpty()){
            return 0;
        }else {
            return Integer.parseInt(Validacao);
        }
    }

    public static int ValidaEntrada(String valida){
        if(valida == null || valida.isEmpty()){
            return 0;
        }else {
            return Integer.parseInt(valida);
        }
    }

    public static int PedidoAcucar(){
        return JOptionPane.showConfirmDialog(null,
                "Deseja colocar acucar?", "Confirmacao", JOptionPane.YES_NO_OPTION);
    }

    public static int PedidoLeite(){
        return JOptionPane.showConfirmDialog(null,
                "Deseja colocar leite?", "Confirmacao", JOptionPane.YES_NO_OPTION);
    }

    public static int PedidoAgua(){
        return JOptionPane.showConfirmDialog(null,
                "Deseja colocar agua?", "Confirmacao", JOptionPane.YES_NO_OPTION);
    }

    public static void main(String[] args) {
        //Funcionalidades da Compra
        List<Produto> carrinhoCompra = new ArrayList<>();
        Double somaTotal = 0.0;
        String nomeCliente = null;
        int numeroPedido = 0;
        int pedidoProduto = 0;
        int desejaTerminar = 0;

        nomeCliente = JOptionPane.showInputDialog(null, "Informe o Nome do Cliente: ",
                "Padaria da Esquina", JOptionPane.INFORMATION_MESSAGE);

        while (nomeCliente == null || nomeCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome Invalido!!!", "Verificacao Nome",
                    JOptionPane.ERROR_MESSAGE);
            nomeCliente = JOptionPane.showInputDialog(null, "Informe o Nome do Cliente: ",
                    "Padaria da Esquina", JOptionPane.INFORMATION_MESSAGE);
        }


        System.out.println("Nome do Cliente: " + nomeCliente);

        do{

            numeroPedido = EscolherPedido();

            while (numeroPedido != 1 && numeroPedido != 2 && numeroPedido != 3){
                JOptionPane.showMessageDialog(null,
                        "Numero de Pedido Invalido!!!", "Padaria da Esquina", JOptionPane.ERROR_MESSAGE);
                numeroPedido = EscolherPedido();
            }

            try {
                if (numeroPedido == 1) {
                    //Criando os produtos de bolo e colocando os precos
                    Produto boloChocolate = Factory.criarBolo("Bolo de Chocolate", 55.00);
                    Produto boloMorango = Factory.criarBolo("Bolo de Morango", 50.00);
                    Produto boloBaunilha = Factory.criarBolo("Bolo de Baunilha", 47.00);

                    String auxVerificacao = JOptionPane.showInputDialog(null,
                            "1 - " + boloChocolate + "\n" + "2 - " + boloMorango + "\n" + "3 - " + boloBaunilha,
                            "Padaria da Esquina", JOptionPane.INFORMATION_MESSAGE);

                    pedidoProduto = ValidaEntrada(auxVerificacao);

                    switch (pedidoProduto) {
                        case 1:
                            carrinhoCompra.add(boloChocolate);
                            break;
                        case 2:
                            carrinhoCompra.add(boloMorango);
                            break;
                        case 3:
                            carrinhoCompra.add(boloBaunilha);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,
                                    "Numero do Produto Invalido ou Produto Cancelado!!!",
                                    "Padaria da Esquina", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }


            try {
                if(numeroPedido == 2){
                    int complementoSuco = 0;
                    //Criando os produtos de suco e colocando os precos
                    Produto sucoLaranja = Factory.criarSuco("Suco de Laranja", 10.00);
                    Produto sucoLimao = Factory.criarSuco("Suco de Limao", 12.00);
                    Produto sucoUva = Factory.criarSuco("Suco de Uva", 13.00);

                    String auxVerificacao = JOptionPane.showInputDialog(null,
                            "1 - " + sucoLaranja + "\n" + "2 - " + sucoLimao + "\n" + "3 - " + sucoUva,
                            "Padaria da Esquina", JOptionPane.INFORMATION_MESSAGE);

                    pedidoProduto = ValidaEntrada(auxVerificacao);

                    switch (pedidoProduto){
                        case 1:
                            complementoSuco = PedidoAcucar();
                            if (complementoSuco == JOptionPane.YES_OPTION){
                                sucoLaranja = new AcucarDecorador(sucoLaranja);
                                carrinhoCompra.add(sucoLaranja);
                            }else {
                                carrinhoCompra.add(sucoLaranja);
                            }
                            break;
                        case 2:
                            complementoSuco = PedidoAcucar();
                            if (complementoSuco == JOptionPane.YES_OPTION){
                                sucoLimao = new AcucarDecorador(sucoLimao);
                                carrinhoCompra.add(sucoLimao);
                            }else {
                                carrinhoCompra.add(sucoLimao);
                            }
                            break;
                        case 3:
                            complementoSuco = PedidoAcucar();
                            if (complementoSuco == JOptionPane.YES_OPTION){
                                sucoUva = new AcucarDecorador(sucoUva);
                                carrinhoCompra.add(sucoUva);
                            }else {
                                carrinhoCompra.add(sucoUva);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,
                                    "Numero do Produto Invalido ou Produto Cancelado!!!",
                                    "Padaria da Esquina", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            try {
                if (numeroPedido == 3){
                    pedidoProduto = 0;
                    int complementoAcucar = 0, complementoLeite = 0, complementoAgua = 0;
                    //Criando o produto cafe e colocando os precos
                    Produto cafe = Factory.criarCafe("Cafe Preto", 15.00);

                    String auxVereificacao =  JOptionPane.showInputDialog(null,
                            "1 - " + cafe, "Mostrando o Cafe", JOptionPane.INFORMATION_MESSAGE);

                    pedidoProduto = ValidaEntrada(auxVereificacao);

                    switch (pedidoProduto){
                        case 1:
                            complementoAcucar = PedidoAcucar();
                            if(complementoAcucar == JOptionPane.YES_OPTION){
                                cafe = new AcucarDecorador(cafe);
                            }

                            complementoLeite = PedidoLeite();
                            if (complementoLeite == JOptionPane.YES_OPTION) {
                                cafe = new LeiteDecorador(cafe);
                            }

                            complementoAgua = PedidoAgua();
                            if (complementoAgua == JOptionPane.YES_OPTION){
                                cafe = new AguaDecorador(cafe);
                            }
                            carrinhoCompra.add(cafe);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,
                                    "Numero do Produto Invalido ou Produto Cancelado!!!",
                                    "Padaria da Esquina", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        desejaTerminar = JOptionPane.showConfirmDialog(null,
                "Deseja finalizar a Compra?", "Finalizacao do Pedido", JOptionPane.YES_NO_OPTION);

        }while (desejaTerminar != JOptionPane.YES_OPTION);


        System.out.println("Pedido:");
        for (Produto item : carrinhoCompra) {
            System.out.println("    " + item.getNome() + " Preco: R$" + item.calcularPreco());
            somaTotal += item.calcularPreco();
        }
        System.out.println("Total da Compra: R$" + somaTotal + "\n");

        File file = new File("ComprovanteDeCompra.txt");

        if (file.exists()){
            System.out.println("Arquivo " + file.getName() + " existe.\n");
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("Nome do Cliente: " + nomeCliente + "\n");
                bufferedWriter.write("Pedido:\n");
                for (Produto produto : carrinhoCompra){
                    bufferedWriter.write("    " + produto.getNome() + " Preco: R$" + produto.calcularPreco()+ "\n");
                }
                bufferedWriter.write("Total da Compra: R$" + somaTotal);
                bufferedWriter.close();
                System.out.println("Arquivo " + file.getName() + " teve seus dados gravado com sucesso.");
            }catch (Exception e){
                System.err.println("Erro criando arquivo " + e.getMessage());
            }

        }else{
            System.out.println("Arquivo " + file.getName()+ " nao existe.\n");

            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("Nome do Cliente: " + nomeCliente + "\n");
                bufferedWriter.write("Pedido:\n");
                for (Produto produto : carrinhoCompra){
                    bufferedWriter.write("    " + produto.getNome() + " Preco: R$" + produto.calcularPreco() + "\n");
                }
                bufferedWriter.write("Total da Compra: R$" + somaTotal);
                bufferedWriter.close();
                System.out.println("Arquivo " + file.getName() + " teve seus dados gravado com sucesso.");
            }catch (Exception e){
                System.err.println("Erro criando arquivo " + e.getMessage());
            }
        }

    }
}