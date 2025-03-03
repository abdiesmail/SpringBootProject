package org.example.SpringMVC;

import org.example.SpringMVC.Dao.AlienDao;
import org.example.SpringMVC.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.soap.Addressing;

@Controller
public class HomeController {

    @Autowired
    private AlienDao dao;

    @ModelAttribute
    public void msg(Model m) {
        m.addAttribute("name","aliens");
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {
        m.addAttribute("alienList", dao.findAll());
        return "getAliens";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m){
        int num3 = i + j;
        m.addAttribute("num3",num3);
        return "add";
    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute("alienList") Alien a) {
        dao.addAlien(a);
        return "getAliens";
    }
    @GetMapping("getAlien")
    public String getAlien (@RequestParam int aid, Model m) {
        m.addAttribute("alienList", dao.find(aid));
        return "getAliens";
    }

}
