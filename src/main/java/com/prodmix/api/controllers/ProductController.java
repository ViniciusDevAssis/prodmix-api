package com.prodmix.api.controllers;

import java.net.URI;
import java.util.List;

import com.prodmix.api.dtos.CreateProductDto;
import com.prodmix.api.dtos.ResponseProductDto;
import com.prodmix.api.dtos.UpdateProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prodmix.api.services.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ResponseProductDto> createProduct(
        @RequestBody CreateProductDto body
    ) {
        ResponseProductDto createdProduct = service.createProduct(body);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdProduct.getId()).toUri();
        return ResponseEntity.created(uri).body(createdProduct);
    }

    @PatchMapping("/update")
    public ResponseEntity<ResponseProductDto> updateProduct(
            @RequestBody UpdateProductDto body,
            @RequestParam String description
    ) {
        ResponseProductDto updatedProduct = service.updateProduct(body, description);
        return ResponseEntity.ok(updatedProduct);
    }

    @PatchMapping("/toggleStatus")
    public ResponseEntity<Void> toggleProductStatus(@RequestParam String description){
        service.toggleProductStatus(description);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDto>> listActiveProducts() {
        return ResponseEntity.ok(service.listActiveProducts());
    }
}
