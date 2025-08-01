package com.prodmix.api.services;

import com.prodmix.api.dtos.CreateStoreDto;
import com.prodmix.api.dtos.ResponseStoreDto;
import com.prodmix.api.entities.Store;
import com.prodmix.api.mappers.StoreMapper;
import com.prodmix.api.repositories.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final StoreRepository repository;
    private final StoreMapper mapper;

    @Transactional
    public ResponseStoreDto register(CreateStoreDto dto) {
        Store store = mapper.createStoreDTOToStore(dto);
        Store savedStore = repository.save(store);
        return mapper.storeToResponseStoreDTO(savedStore);
    }

    public Long getStoreIdFromToken() {
        Object principal = SecurityContextHolder
        .getContext()
        .getAuthentication()
        .getPrincipal();
        if (principal instanceof UserDetails) {
            return ((Store) principal).getId();
        } else {
            return Long.parseLong(principal.toString());
        }
    }
}
