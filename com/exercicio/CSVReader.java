package com.exercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader implements AutoCloseable {
    private BufferedReader br;

    public CSVReader(String fileReader) throws IOException {
        this.br = new BufferedReader(new FileReader(fileReader));
    }

    public CSVReader(FileReader fileReader) {
        //TODO Auto-generated constructor stub
    }

    public CSVReader() {
        //TODO Auto-generated constructor stub
    }

    public String[] readNext() throws IOException {
        String line = br.readLine();
        if (line != null) {
            return line.split(",");  // Assumindo que a vírgula é o separador
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        if (br != null) {
            br.close();
        }
    }
}
