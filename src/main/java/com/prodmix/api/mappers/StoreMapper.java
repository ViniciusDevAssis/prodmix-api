package com.prodmix.api.mappers;

import com.prodmix.api.dtos.CreateStoreDto;
import com.prodmix.api.dtos.ResponseDto;
import com.prodmix.api.dtos.ResponseStoreDto;
import com.prodmix.api.dtos.UpdateStoreDto;
import com.prodmix.api.entities.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    //Para uma única Store
    CreateStoreDto storeToCreateStoreDto(Store store);
    Store createStoreDTOToStore(CreateStoreDto dto);

    @Mapping(source = "name", target = "name")
    ResponseStoreDto storeToResponseStoreDTO(Store store);
    Store responseStoreDTOToStore(ResponseStoreDto dto);
    ResponseDto storeToResponseDTO(Store store);
    Store responseDTOToStore(ResponseDto dto);
    UpdateStoreDto storeToUpdateStoreDTO(Store store);
    Store updateStoreDTOToStore(UpdateStoreDto dto);

    //Para uma lista de Stores
    List<ResponseStoreDto> StoresToListDto(List<Store> stores);
}
