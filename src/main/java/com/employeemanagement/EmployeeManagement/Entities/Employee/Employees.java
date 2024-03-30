package com.employeemanagement.EmployeeManagement.Entities.Employee;

import com.employeemanagement.EmployeeManagement.Entities.Address.Address;
import com.employeemanagement.EmployeeManagement.Entities.Department.Laptop;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_username",columnNames = "username"),
                @UniqueConstraint(name = "unique_email",columnNames = "email"),
                @UniqueConstraint(name = "unique_phonenumber",columnNames = "phonenumber"),
        }
)
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer employeeID;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(name = "phonenumber",nullable = false)
    private Long empPhoneNumber;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Address.class)
    @JoinColumn(name = "emp_addr_id",referencedColumnName = "address_id")
    Address address;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_laptop_id")
    List<Laptop> laptopList;

}
