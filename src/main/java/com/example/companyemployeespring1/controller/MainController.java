package com.example.companyemployeespring1.controller;

import com.example.companyemployeespring1.repository.CompanyRepository;
import com.example.companyemployeespring1.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/")
    public String main() {
        return "main";
    }


}
