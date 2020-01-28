package projetlocalhub.ExtractionService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author S.RABONARIJAONA
 * @see https://mkyong.com/java/how-to-get-url-content-in-java/
 */

class HTMLExtracteur {


    final String FOLDER_PATH = "Data/HTML/";
    URL url;

    public void extract(String url, String fileName) {
		try {
			// get URL content
			this.url = new URL(url);
			URLConnection conn = this.url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

			String inputLine;

			//save to this filename
			String filePath = this.FOLDER_PATH + fileName;
			File file = new File(filePath);

			if (!file.exists()) {
				file.createNewFile();
			}

			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
            }
            
			bw.close();
			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}