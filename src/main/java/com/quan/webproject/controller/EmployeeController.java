package com.quan.webproject.controller;

import com.quan.webproject.dao.EmployeeDao;
import com.quan.webproject.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    // Select all employee
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);

        // thymeleaf will resolve directory
        // classpath:/templates/xxx/.html
        return "emp/list";
    }
}
