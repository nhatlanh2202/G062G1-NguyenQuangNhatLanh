package com.codegym.controller;


import com.codegym.entity.Contract;
import com.codegym.entity.ContractDetail;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceService serviceService;


    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServiceService attachServiceService;

    @GetMapping
    public ModelAndView listContract(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam(value = "search", defaultValue = "") String search) {
        ModelAndView modelAndView = new ModelAndView("contract/listContract");
        Page<Contract> contracts = contractService.findAllCusUseSer(pageable);
        modelAndView.addObject("contracts", contracts);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateContract(){
        ModelAndView modelAndView = new ModelAndView("contract/createContract");
        modelAndView.addObject("contracts", new Contract());
        modelAndView.addObject("service",serviceService.findAll());
        modelAndView.addObject("customer",customerService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("success", "Saved contract successfully!");
        return "redirect:/contract";
    }

    @GetMapping("/contract-detail/create")
    public ModelAndView showCreateFormContractDetail(){
        ModelAndView modelAndView = new ModelAndView("contract/createContractDetail");
        modelAndView.addObject("contractDetail", new ContractDetail());
        modelAndView.addObject("contracts",contractService.findAll());
        modelAndView.addObject("attach",attachServiceService.findAll());
        return modelAndView;
    }

    @PostMapping("/contract-detail/save")
    public String saveContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail,
                                     RedirectAttributes redirectAttributes){
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("success", "Saved contract detail successfully!");
        return "redirect:/contract/contract-detail/create";
    }
}
