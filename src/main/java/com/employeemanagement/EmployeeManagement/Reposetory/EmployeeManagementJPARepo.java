package com.employeemanagement.EmployeeManagement.Reposetory;

import com.employeemanagement.EmployeeManagement.Entities.Employee.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeManagementJPARepo extends JpaRepository<Employees, Integer> {
    public Employees findByEmpPhoneNumber(Long number);
}
