package com.vilasha.shoppinglist.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRepresentation {

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 3, max = 16)
    private String password;

    @NotBlank
    @Size(min = 3, max = 16)
    private String repeatPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
