package com.employeemanagement.EmployeeManagement.Service;


import com.employeemanagement.EmployeeManagement.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeManagementService {

    //Create an Employee
    public EmployeeDTO createEmployee(EmployeeDTO EmployeeDTO);

    //Update an Employee
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO getEmployeeByID(Integer empID);

    public EmployeeDTO getEmployeeByPhoneNumber(Long number);

}
