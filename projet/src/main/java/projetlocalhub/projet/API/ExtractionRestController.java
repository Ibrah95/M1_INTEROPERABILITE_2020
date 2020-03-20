package projetlocalhub.projet.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import projetlocalhub.projet.ExtractionService.*;
import javax.inject.Inject;

@RestController
public class ExtractionRestController {

        @Inject
        HTMLExtracteur htmlExtracteurService;
        @Inject
        HTMLParser htmlParserService;
        @Inject
        CSVExtracteur csvExtracteurService;

        final String[][] HTML_SOURCES = {
                        { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/organisation-des-bu.html",
                                        "ORGANISATION.html" },
                        { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/bu-roanne.html",
                                        "INFOS-ROANNE.html" },
                        { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/bu-sante.html",
                                        "INFOS-SANTE.html" },
                        { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/bu-sciences.html",
                                        "INFOS-SCIENCE.html" },
                        { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/annexe-manufacture.html",
                                        "INFOS-ANNEXE-MANUFACTURE.html" },
                        { "http://www.iut.univ-st-etienne.fr/fr/presentation/l-iut-de-saint-etienne/bibliotheque.html",
                                        "INFOS-IUT.html" },
                        { "https://cercrid.univ-st-etienne.fr/fr/le-centre-de-documentation/informations-pratiques.html",
                                        "INFOS-CERCRID.html" },
                        { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/bibliotheques-associees/centre-de-documentation-recherche-en-all-shs.html",
                                        "INFOS-ALL-SHS.html" } };

        final String[][] CSV_SOURCES = {
                {"les-1000-titres-les-plus-reserves-dans-les-bibliotheques-de-pret.csv", ";"},
                {"les-titres-les-plus-pretes.csv", ","},
        };

        @GetMapping("/api/extraction/html")
        public ResponseEntity<String> extractHTML() {
                System.out.println("extrait les ressources html");
                for (int i = 0; i < HTML_SOURCES.length; i++) {
                        this.htmlExtracteurService.extract(HTML_SOURCES[i][0], HTML_SOURCES[i][1]);
                }
                return new ResponseEntity<String>(HttpStatus.OK);
        }

        @GetMapping("/api/parse/html")
        public ResponseEntity<String> parseHTML() {
                System.out.println("parse les informations dans les ressources html");
                // parse l'organisation
                htmlParserService.parseOrganisation(HTML_SOURCES[0][1]);
                // parse l'info sur ROANNE
                htmlParserService.deleteAllLibraryInfos();
                htmlParserService.parseRoane(HTML_SOURCES[1][1]);
                htmlParserService.parseSante(HTML_SOURCES[2][1]);
                htmlParserService.parseScience(HTML_SOURCES[3][1]);
                htmlParserService.parseIUT(HTML_SOURCES[4][1]);
                htmlParserService.parseCERCRID(HTML_SOURCES[5][1]);
                return new ResponseEntity<String>(HttpStatus.OK);
        }

        @GetMapping("/api/extraction/csv")
        public ResponseEntity<String> extractCSV() {
                System.out.println("extrait les informations des csv");
                for (String[] csv : CSV_SOURCES) {
                        this.csvExtracteurService.extract(csv[0], csv[1].charAt(0));
                }
                return new ResponseEntity<String> (HttpStatus.OK);
        }
}
