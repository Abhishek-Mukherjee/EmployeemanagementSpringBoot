package com.employeemanagement.EmployeeManagement.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LaptopDTO {
    Integer laptopId;

    @NotBlank
    String model_name;
    String specs;
}
