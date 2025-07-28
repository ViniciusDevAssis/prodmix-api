package com.prodmix.api.entities;

import com.prodmix.api.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_stores")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Store {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String logoUrl;

    @Column(nullable = false, unique = true, updatable = false)
    private final UUID slug =UUID.randomUUID();

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
