package sec.project.controller;

import database.Database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController implements Serializable {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String loadAll(Model model) {
        model.addAttribute("amount", String.valueOf(signupRepository.findAll().size()));
        model.addAttribute("people", signupRepository.findAll());
         Database db = new Database();
        
        List<String> dbl = new ArrayList<>();
        try {
            dbl = db.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        model.addAttribute("base", dbl);
        return "alldata";
    }

    @RequestMapping(value = "/done", method = RequestMethod.GET)
    public String loadDone(Model model) {
        model.addAttribute("amount", String.valueOf(signupRepository.findAll().size()));
        model.addAttribute("people", signupRepository.findAll());

        return "done";
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String addDB(@RequestParam String name, @RequestParam String address) {
        Database db = new Database();
        
        
        try {
            db.add(name, address);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:all";
    }
    @RequestMapping(value = "/delall", method = RequestMethod.POST)
    public String delDB(@RequestParam String name) {
        Database db = new Database();
        
        
        try {
            db.delete(name);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:all";
    }
    
    
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address) {

        Signup su = new Signup(name, address);
        signupRepository.save(su);
        return "redirect:done";
    }

}
