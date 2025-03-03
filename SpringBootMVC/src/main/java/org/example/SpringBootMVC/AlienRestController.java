package org.example.SpringBootMVC;

import org.example.SpringBootMVC.model.Alien;
import org.example.SpringBootMVC.repo.AlienRepo;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlienRestController {

    @Autowired
    private AlienRepo repo;

    @GetMapping(path = "aliens", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Alien> getAliens() {
        List<Alien> aliens = repo.findAll();
        return aliens;
    }

    @GetMapping("alien/{a}")
    public Alien getAliens(@PathVariable("a") int aid) {
        Alien alien = repo.findById(aid).orElse(new Alien(0,""));
        //Alien alien = repo.getOne(aid);
        return alien;
    }

    @PostMapping(path="alien", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Alien addAlien(@RequestBody Alien a) {
        repo.save(a);
        return a;
    }

}
