package com.rttCom.rttCom.utils;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.rttCom.rttCom.model.Fornitore;
import com.rttCom.rttCom.model.Prodotto;

public class Inditex implements Fornitore {
	
    private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/inditex.csv";

    @Override
    public List<Prodotto> getCatalogoProdotti() {
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        
        try {
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
                // Reading Records One by One in a String array
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    prodotti.add(new Prodotto(nextRecord[0],nextRecord[1], nextRecord[2], nextRecord[3], nextRecord[4], nextRecord[5], Double.parseDouble(nextRecord[6])));
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
        return prodotti;
    }

    @Override
    public int getId() {
        return 2;
    }

}
