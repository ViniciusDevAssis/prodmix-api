package com.prodmix.api.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prodmix.api.controllers.advice.exceptions.StoreIdNotFoundException;
import com.prodmix.api.dtos.ResponseStoreDto;
import com.prodmix.api.dtos.UpdateStoreDto;
import com.prodmix.api.entities.Store;
import com.prodmix.api.enums.Errors;
import com.prodmix.api.enums.Status;
import com.prodmix.api.mappers.StoreMapper;
import com.prodmix.api.repositories.StoreRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repository;
    private final AuthService auth;
    private final StoreMapper mapper;
    private final PasswordEncoder passwordEncoder;

    protected Store findStoreById() {
        Long id = auth.getStoreIdFromToken();
        return repository.findById(id).orElseThrow(
            () -> new StoreIdNotFoundException(Errors.PSE101)
        );
    }

    @Transactional
    public ResponseStoreDto updateStore(UpdateStoreDto body) {
        Store store = findStoreById();

        store.setName(
            body.getName() != null && !body.getName().isBlank()
            ? body.getName() : store.getName()
        );
        store.setEmail(
            body.getEmail() != null && !body.getEmail().isBlank()
            ? body.getEmail() : store.getEmail()
        );
        store.setPassword(
            body.getPassword() != null && !body.getPassword().isBlank()
            ? passwordEncoder.encode(body.getPassword()) : store.getPassword()
        );
        store.setLogoUrl(
            body.getLogoUrl() != null && !body.getLogoUrl().isBlank()
            ? body.getLogoUrl() : store.getLogoUrl()
        );

        Store updatedStore = repository.save(store);
        return mapper.storeToResponseStoreDTO(updatedStore);
    }

    @Transactional
    public void toggleStoreStatus(){
        Store store = findStoreById();

        if (store.getStatus() == Status.ACTIVE) {
            store.setStatus(Status.INACTIVE);
            repository.save(store);
        } else {
            store.setStatus(Status.ACTIVE);
            repository.save(store);
        }
    }
}