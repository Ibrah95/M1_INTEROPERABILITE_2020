package projetlocalhub.projet.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;


    String ligne;
    String arret;

    public Transport() {

    }

    public Transport(String ligne, String arret) {
        this.ligne = ligne;
        this.arret = arret;
    }

}