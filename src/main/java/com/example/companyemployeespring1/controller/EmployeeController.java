package com.example.companyemployeespring1.controller;

import com.example.companyemployeespring1.entity.Company;
import com.example.companyemployeespring1.entity.Employee;
import com.example.companyemployeespring1.service.CompanyService;
import com.example.companyemployeespring1.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;
    private final CompanyService companyService;
    @Value("${companyEmployeeSpring1.upload.path}")
    private String imagePath;


    @GetMapping("/employees")
    public String employees(ModelMap map) {
        List<Employee> employees = employeeService.findAll();
        List<Company> companies = companyService.findAll();
        map.addAttribute("employees", employees);
        map.addAttribute("companies", companies);
        return "employees";
    }


    @GetMapping("deleteemployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @PostMapping("/addemployee")
    public String addEmployee(@ModelAttribute Employee employee,
                              @RequestParam("pictures") MultipartFile[] multipartFiles) throws IOException {

        if(multipartFiles!=null){
        employeeService.save(employee);
        }
        employeeService.saveWithImage(multipartFiles,employee);



        return "redirect:/employees";
    }


    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@RequestParam("picName") String picName) throws IOException {
        InputStream inputStream = new FileInputStream(imagePath + picName);
        return IOUtils.toByteArray(inputStream);
    }


    @GetMapping("employees/{id}")
    public String singleEmployee(@PathVariable int id, ModelMap map) {
        Employee employee = employeeService.findById(id).orElseThrow(RuntimeException::new);
        map.addAttribute("employee", employee);
        map.addAttribute("company", companyService.findAll());
        return ("singleEmployee");
    }


}
