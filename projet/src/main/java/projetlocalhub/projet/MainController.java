package projetlocalhub.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import projetlocalhub.projet.modele.DemandeRepository;
import projetlocalhub.projet.modele.*;

@Controller
public class MainController {
    

    @Autowired
    DemandeRepository demandeRepo;

    @GetMapping("/")
    public String pageAccueil(Model model,@ModelAttribute("demande") Demande d){
        return "index";
    }


    @PostMapping("/")
    public String postaccueuil(Model model, @ModelAttribute("demande") Demande d){
        System.out.println(d.getQuestion());
        String [] motCles = d.getQuestion().split(" ");
        model.addAttribute("phrase", d.getQuestion());
        model.addAttribute("motCles", motCles);
        return "resultat";
    }




}