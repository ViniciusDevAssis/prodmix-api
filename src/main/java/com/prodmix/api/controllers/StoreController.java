package com.prodmix.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prodmix.api.dtos.ResponseStoreDto;
import com.prodmix.api.dtos.UpdateStoreDto;
import com.prodmix.api.services.StoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;

    @PatchMapping("/update")
    public ResponseEntity<ResponseStoreDto> updateStore(
        @RequestBody UpdateStoreDto body
    ) {
        ResponseStoreDto updatedStore = service.updateStore(body);
        return ResponseEntity.ok(updatedStore);
    }

    @PatchMapping("/toggleStatus")
    public ResponseEntity<Void> toggleStoreStatus(){
        service.toggleStoreStatus();
        return ResponseEntity.noContent().build();
    }
}
