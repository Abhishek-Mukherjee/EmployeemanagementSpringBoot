package com.employeemanagement.EmployeeManagement.Service;

import com.employeemanagement.EmployeeManagement.DTO.EmployeeDTO;
import com.employeemanagement.EmployeeManagement.Entities.Employee.Employees;
import com.employeemanagement.EmployeeManagement.Reposetory.EmployeeManagementJPARepo;
import com.employeemanagement.EmployeeManagement.exception.runtime.EmployeeRuntimeException.EmployeeRuntimeException;
import com.employeemanagement.EmployeeManagement.mapper.EmployeeDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeManagementServicevImpl implements EmployeeManagementService {

    @Autowired
    EmployeeManagementJPARepo employeeManagementJPARepo;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO EmployeeDTO) {
        // Fetch Employees entity from EmployeeDTO
        Employees employees = EmployeeDTOMapper.getEmployeeEntityFromEmployeeDTO(EmployeeDTO);

        //Save Employees entity into the database
        Employees savedEmployee = employeeManagementJPARepo.save(employees);

        //Return EmployeeDTO from savedEmployee object
        return EmployeeDTOMapper.getEmployeeDTOFromEmployeeEntity(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Integer employee_id = employeeDTO.getEmployee_id();
        Employees tobeUpdatedObject = employeeManagementJPARepo.findById(employee_id).get();
        tobeUpdatedObject = EmployeeDTOMapper.getEmployeeEntityFromEmployeeDTO(employeeDTO);
        Employees updatedEmployee = employeeManagementJPARepo.save(tobeUpdatedObject);
        return EmployeeDTOMapper.getEmployeeDTOFromEmployeeEntity(updatedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employees> employees = employeeManagementJPARepo.findAll();
        return employees.stream().map(EmployeeDTOMapper::getEmployeeDTOFromEmployeeEntity).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeByID(Integer empID) {
        Employees employees = employeeManagementJPARepo.findById(empID).orElseThrow();
        return EmployeeDTOMapper.getEmployeeDTOFromEmployeeEntity(employees);
    }

    @Override
    public EmployeeDTO getEmployeeByPhoneNumber(Long phoneNumber) {
        Employees employees = employeeManagementJPARepo.findByEmpPhoneNumber(phoneNumber);
        if(employees == null){
            throw new EmployeeRuntimeException("No employee with this phone number found");
        }
        return EmployeeDTOMapper.getEmployeeDTOFromEmployeeEntity(employees);
    }

}
