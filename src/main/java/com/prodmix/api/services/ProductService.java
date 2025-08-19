package com.prodmix.api.services;

import java.util.List;
import java.util.stream.Collectors;

import com.prodmix.api.enums.Status;
import org.springframework.stereotype.Service;

import com.prodmix.api.controllers.advice.exceptions.ProductDescriptionNotFoundException;
import com.prodmix.api.dtos.CreateProductDto;
import com.prodmix.api.dtos.ResponseProductDto;
import com.prodmix.api.dtos.UpdateProductDto;
import com.prodmix.api.entities.Product;
import com.prodmix.api.entities.Store;
import com.prodmix.api.enums.Errors;
import com.prodmix.api.mappers.ProductMapper;
import com.prodmix.api.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final StoreService store;
    private final ProductMapper mapper;

    @Transactional
    public ResponseProductDto createProduct(CreateProductDto body) {
        Store owner = store.findStoreById();

        Product product = mapper.createProductDtoToProduct(body);
        product.setStore(owner);

        Product savedProduct = repository.save(product);
        return mapper.productToResponseProductDto(savedProduct);
    }

    @Transactional
    public ResponseProductDto updateProduct(UpdateProductDto body, String description) {
        Product product = getProductByDescription(description);

        product.setDescription(
            body.getDescription() != null && !body.getDescription().isBlank()
            ? body.getDescription() : product.getDescription()
        );
        product.setLogoUrl(
            body.getLogoUrl() != null && !body.getLogoUrl().isBlank()
            ? body.getLogoUrl() : product.getLogoUrl()
        );
        product.setCategory(
            body.getCategory() != null ? body.getCategory() : product.getCategory()
        );

        Product updatedProduct = repository.save(product);
        return mapper.productToResponseProductDto(updatedProduct);

    }

    @Transactional
    public void toggleProductStatus(String description) {
        Product product = getProductByDescription(description);

        if (product.getStatus() == Status.ACTIVE) {
            product.setStatus(Status.INACTIVE);
            repository.save(product);
        } else {
            product.setStatus(Status.ACTIVE);
            repository.save(product);
        }
    }

    private List<Product> getProductsByStore() {
        Store owner = store.findStoreById();
        return owner.getProducts();
    }

    private Product getProductByDescription(String description) {
        List<Product> products = getProductsByStore();

        return products.stream().filter(
            p -> p.getDescription().equalsIgnoreCase(description)
        ).findFirst().orElseThrow(
            () -> new ProductDescriptionNotFoundException(Errors.PPE201)
        );
    }

    public List<ResponseProductDto> listActiveProducts() {
        List<Product> products = getProductsByStore();

        List<Product> activeProducts = products.stream()
                .filter(p -> p.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());

        return mapper.productsToListDto(activeProducts);
    }
}
