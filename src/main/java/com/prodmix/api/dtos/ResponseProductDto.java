package com.prodmix.api.dtos;

import com.prodmix.api.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class ResponseProductDto {

    private Long id;
    private String description;
    private String logoUrl;
    private Category category;
}
