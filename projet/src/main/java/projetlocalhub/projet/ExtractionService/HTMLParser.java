package projetlocalhub.projet.ExtractionService;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import projetlocalhub.projet.modele.*;

@Service
public class HTMLParser {

    @Inject
    OrganisationRepository organisationRepo;
    @Inject
    LibraryRepository libraryRepo;

    public void parseOrganisation(String fileName) {
        File input = new File(HTMLExtracteur.FOLDER_PATH + fileName);
        Document doc;
        try {
            doc = Jsoup.parse(input, "UTF-8");
            // supprimer tout les infos dans organisation
            organisationRepo.deleteAll();
            // recuperer le nom et contact du directeur/directrice
            String directorNameSelector = "div#ametys-cms-zone-default-item-N10083 div.ametys-cms-content  p.margin  strong:nth-of-type(2)";
            String directorContactSelector = "div#ametys-cms-zone-default-item-N10083  div.ametys-cms-content  p.margin  a#M5391345913695308";
            String directorName = doc.select(directorNameSelector).text();
            String directorContact = doc.select(directorContactSelector).text();
            // enregistrer le directeur dans la DB locale
            Organisation directeur = new Organisation(directorName, directorContact, "Directeur");
            organisationRepo.save(directeur);
            // recuperer les noms, contacts et intitulés des membres de l'équipe de
            // direction
            String listeMembreSelector = "div#ametys-cms-zone-default-item-N10083  div.ametys-cms-content ul.square  li";
            String membreNameSelector = "strong";
            String membreContactSelector = "a";
            Elements listeMembre = doc.select(listeMembreSelector);
            for (Element membre : listeMembre) {
                String name = membre.select(membreNameSelector).first().text();
                String contact = membre.select(membreContactSelector).first().text();
                String intitule = (membre.text().split(",").length > 1) ? membre.text().split(",")[1] : "INCONNU";
                Organisation newMembre = new Organisation(name, contact, intitule);
                // enregistrer les membres dans la DB locale
                organisationRepo.save(newMembre);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseALLetSHS(String fileName) {
        String mailSelector = "#M057228084550240754";
        String telSelector = ".ametys-cms-content > p:nth-child(14)";
        String adresseSelector = "";
        String serviceSelector = "a.simple";
        String transportSelector = "";
        this.parseLibraryInfo(fileName, "Centre de documentation Recherche en ALL et SHS", mailSelector, telSelector, adresseSelector, serviceSelector, transportSelector);
    }

    public void parseCERCRID(String fileName) {
        String mailSelector = ".margin-black";
        String telSelector = ".contact > p:nth-child(6)";
        String adresseSelector = ".custom > li:nth-child(1)";
        String serviceSelector = "html body div#main-content div.container div.clearfix div.sidebar div.vertical-menu ul.art- li";
        String transportSelector = "";
        this.parseLibraryInfo(fileName, "CERCRID", mailSelector, telSelector, adresseSelector, serviceSelector, transportSelector);
    }

    public void parseIUT(String fileName) {
        String mailSelector = "#M6435593656532081";
        String telSelector = ".contact > p:nth-child(6)";
        String adresseSelector = ".contact > p:nth-child(2)";
        String serviceSelector = "";
        String transportSelector = ".custom li";
        this.parseLibraryInfo(fileName, "Annexe Manufacture", mailSelector, telSelector, adresseSelector, serviceSelector, transportSelector);
    }

    public void parseAnnexeManufacture(String fileName) {
        String mailSelector = "#M5803131561658041";
        String telSelector = ".ametys-cms-content > p:nth-child(20)";
        String adresseSelector = "";
        String serviceSelector = "a.simple";
        String transportSelector = ".custom li";
        this.parseLibraryInfo(fileName, "Annexe Manufacture", mailSelector, telSelector, adresseSelector, serviceSelector, transportSelector);
    }

    public void parseScience(String fileName) {
        String mailSelector = "#M38805475404443035";
        String telSelector = ".ametys-cms-content > p:nth-child(24)";
        String adresseSelector = "";
        String serviceSelector = "a.simple";
        String transportSelector = ".custom li";
        this.parseLibraryInfo(fileName, "Sciences", mailSelector, telSelector, adresseSelector, serviceSelector, transportSelector);
    }

    public void parseRoane(String fileName) {
        String mailSelector = "div#ametys-cms-zone-default-item-N10083 a#M28855786145897133";
        String telSelector = ".ametys-cms-content > p:nth-child(16)";
        String adresseSelector = "#sb_ifc51 > input:nth-child(1)";
        String serviceSelector = "a.simple";
        String transportSelector = "html body div#main-content div.container div.clearfix div.central-column div#ametys-cms-zone-default div#ametys-cms-zone-default-item-N10083.first div.ametys-cms-content.news.view-main.wrapper ul.custom li";
        this.parseLibraryInfo(fileName, "Roanne", mailSelector, telSelector, adresseSelector, serviceSelector, transportSelector);
    }

    public void parseSante(String fileName) {
        String mailSelector = "#M21602123991240252";
        String telSelector = ".ametys-cms-content > p:nth-child(26)";
        String adresseSelector = "#sb_ifc51 > input:nth-child(1)";
        String serviceSelector = "a.simple";
        String transportSelector = "html.wf-museo300-n4-active.wf-gotham-n4-active.wf-active body div#main-content div.container div.clearfix div.central-column div#ametys-cms-zone-default div#ametys-cms-zone-default-item-N10083.first.last div.ametys-cms-content.news.view-main.wrapper ul.custom li";
        this.parseLibraryInfo(fileName, "Santé", mailSelector, telSelector, adresseSelector, serviceSelector, transportSelector);
    }

    private void parseLibraryInfo(String fileName, String libraryName, String mailSelector, String telSelector, String adresseSelector, String serviceSelector, String transportSelector) {
        File input = new File(HTMLExtracteur.FOLDER_PATH + fileName);
        Document doc;
        try {
            doc = Jsoup.parse(input, "UTF-8");
            // recuperer mail tel et adresse 
            String mail = doc.select(mailSelector).text();
            String tel = doc.select(telSelector).text();
            String adresse = (adresseSelector != "") ? doc.select(adresseSelector).text() : "Inconnue";
            Library library = new Library(libraryName, mail, tel, adresse);
            // recuperer les services 
            Elements listeService = (serviceSelector != "") ? doc.select(serviceSelector) : new Elements();
            for (Element service : listeService) {
                ServiceBu newService = new ServiceBu(service.text(), service.attr("href"));
                library.getServices().add(newService);
            }
            // recuperer les transports
            Elements listeTransport = (transportSelector != "") ? doc.select(transportSelector) : new Elements();
            for (Element transport : listeTransport) {
                Transport newTransport = new Transport(transport.text().split(":")[0], transport.text().split(":")[1]);
                library.getTransports().add(newTransport);
            }
            // enregistrer l'info sur la BU dans la DB
            libraryRepo.save(library);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllLibraryInfos() {
        libraryRepo.deleteAll();
    }

}