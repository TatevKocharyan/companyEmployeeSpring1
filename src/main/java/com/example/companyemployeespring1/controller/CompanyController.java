package com.example.companyemployeespring1.controller;

import com.example.companyemployeespring1.entity.Company;
import com.example.companyemployeespring1.repository.CompanyRepository;
import com.example.companyemployeespring1.entity.Company;
import com.example.companyemployeespring1.repository.CompanyRepository;
import com.example.companyemployeespring1.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/companies")
    public String companies(ModelMap map) {
        List <Company> companies=companyService.findAll();
        map.addAttribute("companies", companies);
        return ("companies");
    }

    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute Company company) {
        companyService.save(company);
        return "redirect:companies";
    }

    @GetMapping("/deletecompany/{id}")
    public String deleteCompany(@PathVariable int id) {
        companyService.deleteById(id);
        return "redirect:/companies";
    }
}
