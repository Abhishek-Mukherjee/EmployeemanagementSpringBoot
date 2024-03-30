package com.employeemanagement.EmployeeManagement.Entities.Address;


import com.employeemanagement.EmployeeManagement.Entities.Employee.Employees;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    Integer addressID;

    String street_name;

    @Column(nullable = false)
    String district;

    @Column(nullable = false)
    Integer pincode;

    @Column(nullable = false)
    String state;

    @Column(nullable = false)
    String country;


}
