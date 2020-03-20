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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }


}