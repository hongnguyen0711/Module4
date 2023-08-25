package com.example.form_dang_ki.dto;

import javax.validation.constraints.*;

public class UserDto {

    @Size(min = 5, max = 45, message = "Malformed")
    private String firstName;
    @Size(min = 5, max = 45, message = "Malformed")
    private String lastName;
    @Pattern(regexp = "^0[0-9]{9}$", message = "Malformed")
    private String phoneNumber;
    @Min(value = 18, message = "Must be over 18 years old")
    private int age;
    @Email(message = "Email Malformed")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
