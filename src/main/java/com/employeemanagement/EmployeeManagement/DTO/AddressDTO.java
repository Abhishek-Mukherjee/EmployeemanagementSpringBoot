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
public class AddressDTO {
    Integer addressID;

    String street_name;

    @NotBlank
    String district;

    @NotBlank
    Integer pincode;

    @NotBlank
    String state;

    @NotBlank
    String country;
}
