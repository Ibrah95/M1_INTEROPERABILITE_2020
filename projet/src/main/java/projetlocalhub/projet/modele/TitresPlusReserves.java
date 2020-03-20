package projetlocalhub.projet.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TitresPlusReserves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;


    float rang;
    String typeDeDocument;
    float nombrePrets;
    String titre;
    String nomAuteur;

    public TitresPlusReserves (){
    }

    public TitresPlusReserves(int rang, String typeDeDocument, int nombrePrets, String titre, String nomAuteur) {
        this.rang = rang;
        this.typeDeDocument = typeDeDocument;
        this.nombrePrets = nombrePrets;
        this.titre = titre;
        this.nomAuteur = nomAuteur;
    }

    public TitresPlusReserves(String[] data) {
        for(int i = 0; i < data.length; i++) {
            switch(i) {
                case 0: this.rang = (data[i] != null) ? Float.parseFloat(data[i]) : 0; break;
                case 1: this.typeDeDocument = data[i]; break;
                case 2: this.nombrePrets = (data[i] != null) ? Float.parseFloat(data[i]) : 0; break;
                case 3: this.titre = data[i]; break;
                case 4: this.nomAuteur = data[i];
                case 5: ;
            }
        }
    }

}