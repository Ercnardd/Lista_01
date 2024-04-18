package com.exercicio;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Novo_Produto {
    private String nome;
    private double preco;
    private int quantidade;

    
    public Novo_Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

   
    public void exibirDetalhes() {
        System.out.printf("Nome: %s\nPreço: %.2f\nQuantidade: %d\n\n", nome, preco, quantidade);
    }

    
    public static void main(String[] args) {
        String arquivoCSV = "produtos.csv";
        List<Novo_Produto> produtos = new ArrayList<>();

        // Leitura do arquivo CSV
        try (CSVReader leitor = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            while ((linha = leitor.readNext()) != null) {
                produtos.add(new Novo_Produto(linha[0], Double.parseDouble(linha[1]), Integer.parseInt(linha[2])));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        // Adicionando novos produtos
        produtos.add(new Novo_Produto("Produto 1", 10.99, 5));
        produtos.add(new Novo_Produto("Produto 2", 20.49, 8));

        // Escrita no arquivo CSV
        try (CSVWriter escritor = new CSVWriter(new FileWriter(arquivoCSV))) {
            for (Novo_Produto produto : produtos) {
                String[] linha = {produto.getNome(), String.format("%.2f", produto.getPreco()), Integer.toString(produto.getQuantidade())};
                escritor.writeNext(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }

        // Exibindo detalhes dos produtos
        for (Novo_Produto produto : produtos) {
            produto.exibirDetalhes();
        }
    }
}
