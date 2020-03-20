package projetlocalhub.projet.modele;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "budget")
public class Budget implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bibliotheque;
    private String budget_par_an;
    private static final long serialVersionUID = -4442280465346281925L;


    public String getBibliotheque() {
        return bibliotheque;
    }

    public String getBudget_par_an() {
        return budget_par_an;
    }

    public void setBudget_par_an(String budget_par_an) {
        this.budget_par_an = budget_par_an;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
    



	
}