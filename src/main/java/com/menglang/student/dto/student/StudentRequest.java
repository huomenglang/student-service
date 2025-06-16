package com.menglang.student.dto.student;

import com.menglang.student.model.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public record StudentRequest(
        @Size(min = 3, max = 30, message = "FirstName Min is 3 and Max Char is 30.")
        @NotNull
        @NotBlank(message = "First Name is Require!")
        String firstName,

        @Size(min = 3, max = 30, message = "LastName Min is 3 and Max Char is 30.")
        @NotNull
        @NotBlank(message = "LastName is Require!")
        String lastName,

        @NotNull
        @NotBlank(message = "Gender Is Require!")
        Gender gender,

        @NotNull
        @NotBlank(message = "Date of Birth is Require!")
        LocalDate birthDate,

        String imageUrl,

        @NotNull
        @NotBlank(message = "Phone Number is Require!")
                @Size(min = 9,max = 20,message = "Incorrect Phone Number Format")
        String phoneNumber,

        @NotNull
        @NotBlank(message = "Address is Require!")
        @Size(min = 10,max = 255, message = "Address Min Char is 10 and Max Char is 255")
        String address,

        @NotNull
        @NotBlank(message = "Place Of Birth Address is Require!")
        @Size(min = 10,max = 255, message = "Place Of Birth  Address Min Char is 10 and Max Char is 255")
        String pobAddress,

        @NotNull
        @NotBlank(message = "Enrollment Date of Birth is Require!")
        LocalDate enrollmentDate,

        @NotNull
        @NotBlank(message = "Parent Field is Require!")
        List<Long> parents
) implements Serializable {
}
