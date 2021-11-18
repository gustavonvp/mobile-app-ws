package com.appdeveloperblog.app.ws.ui.model.request;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @NotNull
    @Size(min = 2, message = "Last name must not be less than 2 characters")
    private String lastName;

    @NotNull
    @Size(min = 2, message = "First name must not be less than 2 characters")
    private String firstName;


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


}
