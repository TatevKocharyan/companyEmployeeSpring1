package com.example.companyemployeespring1.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@NotEmpty(message="Users name cannot be empty.")
    private String name;
    //@NotEmpty(message="Users name cannot be empty.")
    private String surname;
    private String email;
    private String phoneNumber;
    private String salary;
    private String position;

    @OneToOne
    private Company company;
    @OneToMany(mappedBy = "employee")
    private List<EmployeeImage> employeeImages;


}
