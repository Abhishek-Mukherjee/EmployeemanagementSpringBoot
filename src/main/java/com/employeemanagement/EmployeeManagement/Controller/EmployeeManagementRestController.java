package com.employeemanagement.EmployeeManagement.Controller;


import com.employeemanagement.EmployeeManagement.DTO.EmployeeDTO;
import com.employeemanagement.EmployeeManagement.Service.EmployeeManagementServicevImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeManagementRestController {

    @Autowired
    EmployeeManagementServicevImpl employeeManagementService;

    @GetMapping("emp/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employeeDTOS = employeeManagementService.getAllEmployees();
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @GetMapping("emp/id/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable Integer id){
       return new ResponseEntity<>(employeeManagementService.getEmployeeByID(id),HttpStatus.OK);
    }

    @GetMapping("emp/phno/{phonenumber}")
    public ResponseEntity<EmployeeDTO> getEmployeeByPhoneNo(@PathVariable Long phonenumber){
        return new ResponseEntity<>(employeeManagementService.getEmployeeByPhoneNumber(phonenumber),HttpStatus.OK);
    }

    @PostMapping("emp/create")
    public ResponseEntity<EmployeeDTO> createSingelEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeManagementService.createEmployee(employeeDTO),HttpStatus.CREATED);
    }

    @PutMapping("emp/update")
    public ResponseEntity<EmployeeDTO> updateSingelEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeManagementService.updateEmployee(employeeDTO),HttpStatus.CREATED);
    }
}
