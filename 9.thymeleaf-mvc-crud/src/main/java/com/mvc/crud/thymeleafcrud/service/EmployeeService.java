package com.mvc.crud.thymeleafcrud.service;

import com.mvc.crud.thymeleafcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
