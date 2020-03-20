package projetlocalhub.projet.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String nom;
    String contact;
    String intitule;

    public Organisation() {

    }

    public Organisation(String nom, String contact, String intitule) {
        this.nom = nom;
        this.contact = contact;
        this.intitule = intitule;
    }
}