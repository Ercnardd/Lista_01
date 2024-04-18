package com.exercicio;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atualizar_Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public void Produto(String nome, double preco, int quantidade) {
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

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        List<Produto> produtos = new ArrayList<>();

        CSVReader leitor = new CSVReader();
        String[] linha;

        while ((linha = leitor.readNext()) != null) {
            String nome = linha[0];
            double preco = Double.parseDouble(linha[1]);
            int quantidade = Integer.parseInt(linha[2]);
            Produto produto = new Produto(nome, preco, quantidade);
            produtos.add(produto);
        }

        leitor.close();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do produto que deseja atualizar: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o novo preço do produto: ");
        double novoPreco = scanner.nextDouble();

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produto.setPreco(novoPreco);
                break;
            }
        }

        CSVWriter escritor = new CSVWriter(null);
        for (Produto produto : produtos) {
            String[] dados = {produto.getNome(), String.valueOf(produto.getPreco()), String.valueOf(produto.getQuantidade())};
            escritor.writeNext(dados);
        }
        escritor.close();
        System.out.println("Informações atualizadas com sucesso!");

     
        for (Produto produto : produtos) {
            produto.exibirDetalhes();
        }
    }
}
