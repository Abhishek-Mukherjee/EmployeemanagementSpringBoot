package com.employeemanagement.EmployeeManagement.Entities.Department;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "laptop_id")
    Integer laptopId;
    String model_name;
    String specs;

}
