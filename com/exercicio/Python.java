package com.exercicio;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        
        String inputFile = "meuarquivo.txt";
        
        String outputFile = "meuarquivo_python.txt";

        try {
           
            Scanner scanner = new Scanner(new File(inputFile));
            
            FileWriter writer = new FileWriter(outputFile);

            
            while (scanner.hasNextLine()) {
                
                String line = scanner.nextLine();
                
                line = line.replaceAll("Java", "Python");
                
                writer.write(line + "\n");
            }

           
            scanner.close();
            writer.close();
            
            System.out.println("Substituição concluída com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro ao ler/escrever o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
