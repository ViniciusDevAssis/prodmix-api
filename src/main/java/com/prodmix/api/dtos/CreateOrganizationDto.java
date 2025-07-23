package com.prodmix.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class CreateOrganizationDto {

    @NotBlank(message = "O campo nome é obrigatório")
    private String name;

    @NotBlank(message = "O campo email é obrigatório")
    private String email;

    @NotBlank(message = "O campo senha é obrigatório")
    private String password;

    public CreateOrganizationDto() {
    }

    public CreateOrganizationDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
