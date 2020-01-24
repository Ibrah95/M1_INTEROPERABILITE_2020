package projetlocalhub.projet.modele;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import java.util.Date;

/**
 * @author Ibrahima DIALLO
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nom;
    String prenom;
    @DateTimeFormat(pattern = "yyyy")
    Date dateDeNaissance;



    public User(String nom, String prenom, Date dateDeNaissance){
        this.nom=nom;
        this.prenom=prenom;
        this.dateDeNaissance=dateDeNaissance;
    }

    public User (){
        
    }


}