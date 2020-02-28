package projetlocalhub.projet.ExtractionService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

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

    public List<List<String>> extract(String filename, char separator) {
        List<List<String>> records = new ArrayList<List<String>>();
        String filePath = FOLDER_PATH + filename;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser parser = new CSVParserBuilder()
            .withSeparator(separator)
            .withIgnoreQuotations(true)
            .build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
                for (String value : values) {
                    System.out.print(value + " || ");
                }
                System.out.println("");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return records;
    }
}