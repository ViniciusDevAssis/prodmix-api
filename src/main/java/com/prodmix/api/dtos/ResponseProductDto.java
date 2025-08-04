package com.prodmix.api.dtos;

import com.prodmix.api.enums.Category;

public record ResponseProductDto(String description, String logoUrl, Category category) {

}
