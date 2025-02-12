package com.sample.employeemanagement.controller;

import com.sample.employeemanagement.exceptions.EmployeeNotFoundException;
import com.sample.employeemanagement.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    private EmployeeService employeeService;

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        employeeService.deleteEmployees(id);
        return "redirect:/employees"; 
        
    }

}
