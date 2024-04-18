package com.exercicio;
import java.io.FileReader;
import java.io.IOException;

public class LerCSV {
    public static void main(String[] args) {
        String arquivoCSV = "alunos.csv";

        CSVReader leitor = new CSVReader();
        String[] linha;


        while ((linha = leitor.readNext()) != null) {
            for (String coluna : linha) {
                System.out.print(coluna + "\t");
            }
            System.out.println();
        }

        
        leitor.close();
    }
}
