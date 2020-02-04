package projetlocalhub.projet.modele;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ouverture_bu")
public class Ouverture implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String bibliotheque;
	private String ouverture;
	
	
	public String getBibliotheque() {
		return bibliotheque;
	}


	public void setBibliotheque(String bibliotheque) {
		this.bibliotheque = bibliotheque;
	}


	public String getOuverture() {
		return ouverture;
	}


	public void setOuverture(String ouverture) {
		this.ouverture = ouverture;
	}


	private static final long serialVersionUID = -4442280465346281925L;

}
