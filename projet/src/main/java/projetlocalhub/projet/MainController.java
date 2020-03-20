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


    




}