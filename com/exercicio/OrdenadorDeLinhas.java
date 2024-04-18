package com.exercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenadorDeLinhas {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_ordenado.txt";
        
        List<String> linhas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivoEntrada))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        Collections.sort(linhas);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivoSaida))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Linhas ordenadas e salvas em '" + nomeArquivoSaida + "'.");
    }
}
