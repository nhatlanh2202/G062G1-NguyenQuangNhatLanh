package codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("")
public class CondimentsController {
    @GetMapping
    public String showChoice(){
        return "/condiment/choice";
    }

    @RequestMapping("/condiment")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        String b = "";

        for (String c : condiment){
            b += c;
        }
        model.addAttribute("condiment", b);
        return "/condiment/showChoice";
    }
}
