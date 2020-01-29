package projetlocalhub.projet.ExtractionService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

/**
 * @author S.RABONARIJAONA
 * @see https://mkyong.com/java/how-to-get-url-content-in-java/
 */

@Service
public class HTMLExtracteur {

	final String FOLDER_PATH = "DATA/HTML/";
	URL url;

	public void extract(String url, String fileName) {
		try {
			// get URL content
			this.url = new URL(url);
			URLConnection conn = this.url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine;

			// save to this filename
			String filePath = FOLDER_PATH + fileName;
			File file = new File(filePath);

			if (!file.exists()) {
				file.createNewFile();
			}

			// use FileWriter to write file
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