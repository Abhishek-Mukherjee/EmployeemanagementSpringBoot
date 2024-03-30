package com.employeemanagement.EmployeeManagement.mapper;

import com.employeemanagement.EmployeeManagement.DTO.AddressDTO;
import com.employeemanagement.EmployeeManagement.DTO.EmployeeDTO;
import com.employeemanagement.EmployeeManagement.DTO.LaptopDTO;
import com.employeemanagement.EmployeeManagement.Entities.Address.Address;
import com.employeemanagement.EmployeeManagement.Entities.Department.Laptop;
import com.employeemanagement.EmployeeManagement.Entities.Employee.Employees;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDTOMapper {
    public static Employees getEmployeeEntityFromEmployeeDTO(EmployeeDTO employeeDTO){
        Employees employees = new Employees();
            employees.setEmployeeID(employeeDTO.getEmployee_id());
            employees.setUsername(employeeDTO.getUsername());
            employees.setFirstname(employeeDTO.getFirst_name());
            employees.setLastname(employeeDTO.getLastname());
            employees.setEmail(employeeDTO.getEmail());
            employees.setEmpPhoneNumber(Long.parseLong(employeeDTO.getEmp_phone_number()));

        AddressDTO addressDTO = employeeDTO.getAddressDTO();
            Address address = new Address();
            address.setDistrict(addressDTO.getDistrict());
            address.setStreet_name(addressDTO.getStreet_name());
            address.setState(addressDTO.getState());
            address.setPincode(addressDTO.getPincode());
            address.setCountry(addressDTO.getCountry());

        List<LaptopDTO> laptopDTO = employeeDTO.getLaptopDTOS();
        List<Laptop> laptopList = new ArrayList<>();
        laptopDTO.forEach(laptop->{
            Laptop singleLaptop = new Laptop();
            singleLaptop.setModel_name(laptop.getModel_name());
            singleLaptop.setSpecs(laptop.getSpecs());
            laptopList.add(singleLaptop);
        });

        employees.setAddress(address);
        employees.setLaptopList(laptopList);

        return employees;
    }

    public static EmployeeDTO getEmployeeDTOFromEmployeeEntity(Employees employees){
        EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployee_id(employees.getEmployeeID());
            employeeDTO.setUsername(employees.getUsername());
            employeeDTO.setFirst_name(employees.getFirstname());
            employeeDTO.setLastname(employees.getLastname());
            employeeDTO.setEmail(employees.getEmail());
            employeeDTO.setEmp_phone_number(String.valueOf(employees.getEmpPhoneNumber()));

        AddressDTO addressDTO = new AddressDTO();
        Address address = employees.getAddress();
            addressDTO.setAddressID(address.getAddressID());
            addressDTO.setStreet_name(address.getStreet_name());
            addressDTO.setDistrict(address.getDistrict());
            addressDTO.setState(address.getState());
            addressDTO.setCountry(address.getCountry());
            addressDTO.setPincode(address.getPincode());

        employeeDTO.setAddressDTO(addressDTO);

        List<LaptopDTO> laptopDTOS = new ArrayList<LaptopDTO>();
        List<Laptop> laptop = employees.getLaptopList();

            laptop.forEach(laptopItem->{
                LaptopDTO singleLaptop = new LaptopDTO();
                singleLaptop.setSpecs(laptopItem.getSpecs());
                singleLaptop.setModel_name(laptopItem.getModel_name());
                singleLaptop.setLaptopId(laptopItem.getLaptopId());
                laptopDTOS.add(singleLaptop);
            });
        employeeDTO.setLaptopDTOS(laptopDTOS);


        return employeeDTO;
    }
}
