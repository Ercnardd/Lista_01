package com.exercicio;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class detalhes_Produto {
    private String nome;
    private double preco;
    private int quantidade;

  
    public detalhes_Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

  
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println();
    }

    public static void main(String[] args) {
      
        String arquivoCSV = "produtos.csv";


        List<detalhes_Produto> produtos = new ArrayList<>();

        CSVReader leitor = new CSVReader();
        String[] linha;

   
        while ((linha = leitor.readNext()) != null) {
            String nome = linha[0];
            double preco = Double.parseDouble(linha[1]);
            int quantidade = Integer.parseInt(linha[2]);
            detalhes_Produto produto = new detalhes_Produto(nome, preco, quantidade);
            produtos.add(produto);
        }

         
        leitor.close();


        for (detalhes_Produto produto : produtos) {
            produto.exibirDetalhes();
        }
    }
}
