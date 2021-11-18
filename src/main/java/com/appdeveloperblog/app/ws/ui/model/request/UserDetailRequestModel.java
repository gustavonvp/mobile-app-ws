package com.appdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must not be less than 2 characters")
    private String firstName;

    @Size(min = 2, message = "Last name must not be less than 2 characters")
    @NotNull(message = "Last name cannot be null")
    private String lastName;


    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    private Long password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }
}
