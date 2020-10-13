package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.convertService;

@Controller
public class ConvertController {
    @Qualifier("convertServiceImpl")
    @Autowired
    private convertService convertService;

    @GetMapping("/")
    public String convertMoney(){
        return "convert_money";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam String money, Model model){
        int resultFinal = Integer.parseInt(money) * 23000;

        model.addAttribute("resultConvert",resultFinal);

        return "result_convert";
    }
}
