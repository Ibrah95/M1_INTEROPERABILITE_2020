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

    final String[][] HTML_SOURCES = {
            { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/organisation-des-bu.html",
                    "ORGANISATION.html" },
            { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/bu-roanne.html", "INFOS-ROANNE.html" },
            { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/bu-sante.html", "INFOS-SANTE.html" },
            { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/bu-sciences.html", "INFOS-SCIENCE.html" },
            { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/annexe-manufacture.html",
                    "INFOS-ANNEXE-MANUFACTURE.html" },
            { "http://www.iut.univ-st-etienne.fr/fr/presentation/l-iut-de-saint-etienne/bibliotheque.html",
                    "INFOS-IUT.html" },
            { "https://cercrid.univ-st-etienne.fr/fr/le-centre-de-documentation/informations-pratiques.html",
                    "INFOS-CERCRID.html" },
            { "https://scd.univ-st-etienne.fr/fr/tout-savoir-sur-mes-bu/bibliotheques-associees/centre-de-documentation-recherche-en-all-shs.html",
                    "INFOS-ALL-SHS.html" } };

    @GetMapping("/api/extraction/html")
    public ResponseEntity extractHTML() {
        System.out.println("extrait les ressources html");
        for (int i = 0; i < HTML_SOURCES.length; i++) {
            this.htmlExtracteurService.extract(HTML_SOURCES[i][0], HTML_SOURCES[i][1]);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
