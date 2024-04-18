package com.exercicio;

public class LerCSV {
    public static void main(String[] args) throws Exception {
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
