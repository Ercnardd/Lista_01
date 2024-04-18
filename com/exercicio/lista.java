package com.exercicio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco, int i) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public String getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }

    public void setPreco(double novoPreco) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPreco'");
    }

    public void exibirDetalhes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirDetalhes'");
    }

    public char[] getPreco() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPreco'");
    }

    public char[] getQuantidade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuantidade'");
    }
}

public class lista {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Produto> listaProdutos = Arrays.asList(
                new Produto("Celular", 1000.00, 0),
                new Produto("Tablet", 500.00, 0),
                new Produto("Notebook", 1500.00, 0));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("produtos.dat"))) {
            out.writeObject(listaProdutos);
            System.out.println("Lista de produtos serializada com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("produtos.dat"))) {
            List<Produto> produtosDeserializados = (List<Produto>) in.readObject();
            System.out.println("Produtos deserializados:");
            for (Produto produto : produtosDeserializados) {
                System.out.println(produto);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
