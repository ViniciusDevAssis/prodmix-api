package com.prodmix.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateStoreDto {

    @NotBlank(message = "O campo nome é obrigatório")
    private String name;

    @NotBlank(message = "O campo email é obrigatório")
    private String email;

    @NotBlank(message = "O campo senha é obrigatório")
    private String password;
}
