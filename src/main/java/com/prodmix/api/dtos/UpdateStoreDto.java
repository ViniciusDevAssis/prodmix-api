package com.prodmix.api.dtos;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UpdateStoreDto {

    private String name;
    private String email;
    private String password;
}
