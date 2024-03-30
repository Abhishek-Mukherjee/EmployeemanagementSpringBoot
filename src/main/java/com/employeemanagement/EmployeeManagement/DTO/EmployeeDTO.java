package com.employeemanagement.EmployeeManagement.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {

    private Integer employee_id;

    @NotBlank(message = "invalid username")
    private String username;

    @NotBlank(message = "invalid firstname")
    private String first_name;

    @NotBlank(message = "invalid lastname")
    private String lastname;

    @Email(message = "invalid email address")
    private String email;

    @Pattern(regexp = "\\+?\\d[\\d -]{8,12}\\d",message = "invalid phone number")
    private String emp_phone_number;


    private AddressDTO addressDTO;

    @NotNull
    private List<LaptopDTO> laptopDTOS;
}
