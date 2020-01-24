package projetlocalhub.projet.modele;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;


    Date dateDemande;
    String sujet;
    String question;

    public Demande (Date dateDemande, String sujet, String question){
        this.dateDemande=dateDemande;
        this.sujet=sujet;
        this.question=question;
    }
    
    public Demande (){
        
    }





}