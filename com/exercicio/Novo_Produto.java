package com.exercicio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Novo_Produto {
    

    public static void main(String[] args) throws Exception {
        String arquivoCSV = "produtos.csv";
        List<Novo_Produto> produtos = new ArrayList<>();

        CSVReader leitor = null;
        try {
            leitor = new CSVReader(new FileReader(arquivoCSV));
            while ((leitor.readNext()) != null) {
                produtos.add(new Novo_Produto());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        } finally {
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        CSVWriter escritor = null;
        try {
            escritor = new CSVWriter(new FileWriter(arquivoCSV));
            for (Novo_Produto produto : produtos) {
                String[] linha = {produto.getNome(), String.format("%.2f", produto.getPreco()), Integer.toString(produto.getQuantidade())};
                escritor.writeNext(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }
    }

    private Object getPreco() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getPreco'");
    }

    private int getQuantidade() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getQuantidade'");
    }

    private String getNome() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }
}
