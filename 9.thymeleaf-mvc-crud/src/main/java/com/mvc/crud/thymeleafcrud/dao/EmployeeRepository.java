package com.mvc.crud.thymeleafcrud.dao;

import com.mvc.crud.thymeleafcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}
