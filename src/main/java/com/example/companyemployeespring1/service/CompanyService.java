package com.example.companyemployeespring1.service;

import com.example.companyemployeespring1.entity.Company;
import com.example.companyemployeespring1.repository.CompanyRepository;
import com.example.companyemployeespring1.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;


    public List<Company> findAll() {
        return companyRepository.findAll();


    }

    public Company save(Company company) {

        return companyRepository.save(company);
    }


    public void deleteById(int id) {

        companyRepository.deleteById(id);
    }


}
