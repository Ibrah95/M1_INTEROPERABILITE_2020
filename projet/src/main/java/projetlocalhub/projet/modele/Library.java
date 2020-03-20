package projetlocalhub.projet.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String nom;
    String mail;
    String tel;
    String adresse;
    
    @OneToMany(cascade = CascadeType.ALL)
    List<ServiceBu> services = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    List<Transport> transports = new ArrayList<>();

    public Library() {
        
    }

    public Library(String nom, String mail, String tel, String adresse) {
        this.nom = nom;
        this.mail = mail;
        this.tel = tel;
        this.adresse = adresse;
    }

    public List<ServiceBu> getServices() {
        return this.services;
    } 

    public List<Transport> getTransports() {
        return this.transports;
    }

}