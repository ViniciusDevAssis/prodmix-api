package com.prodmix.api.services;

import com.prodmix.api.dtos.CreateStoreDto;
import com.prodmix.api.dtos.ResponseStoreDto;
import com.prodmix.api.entities.Store;
import com.prodmix.api.mappers.StoreMapper;
import com.prodmix.api.repositories.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final StoreRepository repository;
    private final StoreMapper mapper;

    public ResponseStoreDto register(CreateStoreDto dto) {
        Store store = mapper.createStoreDTOToStore(dto);
        Store savedStore = repository.save(store);
        return mapper.storeToResponseStoreDTO(savedStore);
    }
}
