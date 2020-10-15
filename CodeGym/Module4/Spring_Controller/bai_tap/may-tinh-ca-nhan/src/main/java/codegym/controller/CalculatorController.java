package codegym.controller;

import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"","/calculator"})
public class CalculatorController {

    @GetMapping
    public String showCalculator (){
        return "/calculator";
    }

    @PostMapping
    public String calculator(@RequestParam int num1, int num2, String calculation, Model model){
        int result;
        switch (calculation){
            case "add": {
                result = num1 + num2;
                model.addAttribute("result",result);
                model.addAttribute("num1",num1);
                model.addAttribute("num2",num2);
                model.addAttribute("calculation",calculation);
                break;
            }
            case "sub": {
                result = num1 - num2;
                model.addAttribute("result",result);
                model.addAttribute("num1",num1);
                model.addAttribute("num2",num2);
                model.addAttribute("calculation",calculation);
                break;
            }
            case "mul": {
                result = num1 * num2;
                model.addAttribute("result",result);
                model.addAttribute("num1",num1);
                model.addAttribute("num2",num2);
                model.addAttribute("calculation",calculation);
                break;
            }
            case "div": {
                result = num1 / num2;
                model.addAttribute("result",result);
                model.addAttribute("num1",num1);
                model.addAttribute("num2",num2);
                model.addAttribute("calculation",calculation);
                break;
            }
        }
        return "/calculator";
    }
}
