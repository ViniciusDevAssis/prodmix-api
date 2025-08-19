package com.prodmix.api.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prodmix.api.dtos.CreateProductDto;
import com.prodmix.api.dtos.ResponseProductDto;
import com.prodmix.api.dtos.UpdateProductDto;
import com.prodmix.api.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    //Para uma única Product
    CreateProductDto productToCreateProductDto(Product product);
    Product createProductDtoToProduct(CreateProductDto dto);
    ResponseProductDto productToResponseProductDto(Product product);
    Product responseProductDtoToProduct(ResponseProductDto dto);
    UpdateProductDto productToUpdateProductDto(Product product);
    Product updateProductDtoToProduct(UpdateProductDto dto);

    //Para uma lista de Products
    List<ResponseProductDto> productsToListDto(List<Product> products);
}
