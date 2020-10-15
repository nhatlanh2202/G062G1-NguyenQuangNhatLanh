package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.LibraryService;
import service.LibraryServiceImpl;

@Controller
@RequestMapping({"","/library"})
public class LibraryController {
    LibraryService libraryService = new LibraryServiceImpl();

    @GetMapping
    public String showSearchPage(){
        return "/library/home";
    }

    @PostMapping
    public String findByKey(@RequestParam String key, Model model){
        String word = libraryService.findByKey(key);
        model.addAttribute("key",key);
        model.addAttribute("word",word);
        return "/library/home";
    }

}
