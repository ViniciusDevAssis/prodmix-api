package com.prodmix.api.dtos;

import com.prodmix.api.enums.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateProductDto {

    @NotBlank(message = "O campo descrição é obrigatoório")
    private String description;

    private String logoUrl;

    @NotBlank(message = "O Campo categoria é obrigatório")
    private Category category;

}
