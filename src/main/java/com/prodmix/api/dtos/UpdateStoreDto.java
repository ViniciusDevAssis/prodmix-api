package com.prodmix.api.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateStoreDto {

    private String name;
    private String email;
    private String password;
    private String logoUrl;
}
