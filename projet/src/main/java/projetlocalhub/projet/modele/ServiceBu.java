package projetlocalhub.projet.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ServiceBu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;


    String name;
    String href;

    public ServiceBu (){
    }

    public ServiceBu(String name, String href) {
        this.name = name;
        this.href = href;
    }

}