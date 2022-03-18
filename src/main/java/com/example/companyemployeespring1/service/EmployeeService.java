package com.example.companyemployeespring1.service;

import com.example.companyemployeespring1.entity.Employee;
import com.example.companyemployeespring1.entity.EmployeeImage;
import com.example.companyemployeespring1.repository.EmployeeImageRepository;
import com.example.companyemployeespring1.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeImageRepository employeeImageRepository;
    private final EmployeeRepository employeeRepository;


    @Value("${companyEmployeeSpring1.upload.path}")
    private String imagePath;
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }


    public void saveWithImage(MultipartFile[] multipartFiles, Employee employee) throws IOException {
        if (multipartFiles.length != 0) {
            for (MultipartFile multipartFile : multipartFiles) {
                String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
                File file = new File(imagePath + fileName);
                multipartFile.transferTo(file);
                EmployeeImage employeeImage = EmployeeImage.builder()
                        .name(fileName)
                        .employee(employee)
                        .build();
                employeeImageRepository.save(employeeImage);
            }
        }
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }
}
