package com.example.module309.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {

    private Integer id;


    @NotNull(message = "office Id is required.")
    private Integer officeId;

    @Length(max = 50, message = "First name must be less than 50 characters.")
    @NotEmpty(message = "First Name is required.")
    private String firstName;

    @Length(max = 50, message = "Last name must be less than 50 characters.")
    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @Length(max = 10, message = "Extension must be less than 10 characters.")
    @NotEmpty(message = "Extension is required.")
    private String extension;

    @Length(max = 50, message = "Email must be less than 50 characters.")
    @NotEmpty(message = "Email is required.")
    private String email;


    @NotNull(message = "reports To is required.")
    private Integer reportsTo;

    @Length(max = 50, message = "Job tittle must be less than 50 characters.")
    @NotEmpty(message = "Job tittle is required.")
    private String jobTitle;

}
