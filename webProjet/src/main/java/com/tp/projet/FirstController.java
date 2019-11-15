package com.tp.projet;

import javax.inject.Inject;

import com.tp.projet.page.*;
import com.tp.projet.utilisateur.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * FirstController
 */
@Controller
public class FirstController {

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Methodes et attributs de la 1ère version du Projet
     */

    /* Lorsqu'on est connecté */

    @Inject
    public UtilisateurRepository utilisateurRep;

    @Inject
    public ProjetRepository projetRep;

    @Inject
    public TacheRepository tacheRep;

    @Inject
    UserService userService;

    @Inject
    public UserRepository userRep;

    @RequestMapping("/home")
    public String index() {
        return "index";
    }

    /* peut-être en sursis si inutile */
    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

    @RequestMapping("/connection")
    public String connexion(Authentication auth) {
        /* we test if the user is connected */
        if (auth != null) {
            /* if that's the case, we redirect him/her to the member space */
            if (auth.getAuthorities().toString().equals("[USER]")
                    || auth.getAuthorities().toString().equals("[ADMIN]")) {
                return "membre";
            }
        }
        return "connexion";
    }

    @RequestMapping("/promoteuser") /*************************/
    public String promoteuser(Users u) {
        userService.makeUserAdmin(u.getUserName());
        return "redirect:/member";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String whoami(Authentication auth) { // inject Authentication to get more info
        if (auth == null)
            return "Not Logged In";
        return "You are " + auth.getName() + " with " + auth.getAuthorities();
    }

    @RequestMapping("/registration")
    public String inscription(Model m) {
        m.addAttribute("reg", new Utilisateur());
        return "inscription";
    }

    @RequestMapping("/addutilisateur")
    public String addutilisateur(Utilisateur u) {
        u.setPassword(encoder.encode(u.getPassword()));
        utilisateurRep.save(u);
        return "redirect:/member";
    }

    /** Une fois connecté */

    /* page de l'espace membre */
    @RequestMapping("/member")
    public String membre(Model m) {
        m.addAttribute("member", utilisateurRep.findAll());
        m.addAttribute("project", projetRep.findAll());
        return "membre";
    }

    /* page de création d'un projet */

    @RequestMapping("/projetCreate")
    public String projetCreation(Model m) {
        m.addAttribute("member", utilisateurRep.findAll());
        m.addAttribute("pro", new Projet());

        return "projetCreation";
    }

    @RequestMapping("/addprojet")
    public String addprojet(Projet p) {
        projetRep.save(p);
        return "redirect:/member";
    }

    /* page de gestion d'un projet */

    @RequestMapping("/projectManagement/{projectId}")
    public String projetGestion(@PathVariable("projectId") Long projectId, Model m) {
        Projet p;
        p = projetRep.findById(projectId).get();
        m.addAttribute("member", utilisateurRep.findAll());
        m.addAttribute("project", projetRep.findAll());
        m.addAttribute("task", tacheRep.findAll());
        m.addAttribute("pro", p);
        return "projetGestion";
    }

    @PostMapping(value = "/updateprojet")
    public String updateprojet(Projet projetObj) {
        projetRep.save(projetObj);
        return "redirect:/member";
    }

    /* page de création d'une tache */

    @RequestMapping("/taskCreate/{projectId}")
    public String tacheCreation(@PathVariable("projectId") Long projectId, Model m) {

        /*
         * Projet p; p = projetRep.findById(projectId).get();
         */
        Tache t = new Tache();

        /*
         * Tache t ; t = new Tache("", 0, 0.0, "", projectId, new Date(), new Date(),
         * List<Projet> projetList, List<Utilisateur> utilisateurList);
         */

        m.addAttribute("member", utilisateurRep.findAll());
        m.addAttribute("project", projetRep.findAll());
        m.addAttribute("tas", t);

        return "tacheCreation";
    }

    @RequestMapping("/addtache")
    public String addtache(Tache t) {
        tacheRep.save(t);
        return "redirect:/member";
    }

    /* page de gestion d'une tache */

    @RequestMapping("/taskManagement/{projectId}/{taskId}")
    public String tacheGestion(@PathVariable("taskId") Long taskId, @PathVariable("projectId") Long projectId,
            Model m) {
        Tache t;
        t = tacheRep.findById(taskId).get();
        m.addAttribute("member", utilisateurRep.findAll());
        m.addAttribute("project", projetRep.findAll());
        m.addAttribute("task", projetRep.findAll());
        m.addAttribute("tas", t);
        return "tacheGestion";
    }

    @PostMapping(value = "/updatetache")
    public String updatetache(Tache tacheObj) {
        tacheRep.save(tacheObj);
        return "redirect:/member";
    }

    /* page de messagerie d'un projet */

    @RequestMapping("/messaging")
    public String messagerie(Model m) {
        return "messagerie";
    }

    /* page de planning d'un membre */

    @RequestMapping("/schedule")
    public String planning(Model m) {
        return "planning";
    }

    /* page de repository d'un projet */

    @RequestMapping("/repertory")
    public String repertoire(Model m) {
        return "repertoire";
    }

    /* page de repository d'un projet */

    @RequestMapping("/toDoList")
    public String pileDeChoses(Model m) {
        return "pileDeChoses";
    }

}