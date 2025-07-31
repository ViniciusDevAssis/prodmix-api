package com.prodmix.api.entities;

import com.prodmix.api.enums.Category;
import com.prodmix.api.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
}
