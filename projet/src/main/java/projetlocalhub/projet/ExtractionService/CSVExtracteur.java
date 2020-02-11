package projetlocalhub.projet.ExtractionService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

import org.springframework.stereotype.Service;

/**
 * @author S.RABONARIJAONA
 * @see https://www.baeldung.com/java-csv-file-array
 * @see https://www.baeldung.com/opencsv
 */

@Service
public class CSVExtracteur {

    final String FOLDER_PATH = "DATA/CSV/";
    URL url;

    public List<List<String>> extract(String url, String filename) {
        List<List<String>> records = new ArrayList<List<String>>();
        CSVReader csvReader;
        String filePath = FOLDER_PATH + filename;
        try {
            csvReader = new CSVReader(new FileReader(filePath));
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}