package org.example.SpringBootMVC;

import org.example.SpringBootMVC.model.Alien;
import org.example.SpringBootMVC.repo.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private AlienRepo repo;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m){
        int num3 = i + j;
        m.addAttribute("num3",num3);
        return "add";
    }

    @PostMapping("addAlien")  //@RequestMapping(value = "addAlien", method = RequestMethod.GET)
    public String addAlien(@ModelAttribute("alienList") Alien a) {
        repo.save(a);
        return "getAliens";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {
        m.addAttribute("alienList", repo.findAll());
        return "getAliens";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam int aid, Model m) {
        m.addAttribute("alienList", repo.getOne(aid));
        return "getAliens";
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam String aname, Model m) {
        m.addAttribute("alienList", repo.find(aname));
        return "getAliens";
    }


}
