package com.prodmix.api.controllers;

import com.prodmix.api.controllers.advice.exceptions.StoreEmailNotFoundException;
import com.prodmix.api.dtos.CreateStoreDto;
import com.prodmix.api.dtos.LoginDto;
import com.prodmix.api.dtos.ResponseDto;
import com.prodmix.api.dtos.ResponseStoreDto;
import com.prodmix.api.entities.Store;
import com.prodmix.api.enums.Errors;
import com.prodmix.api.mappers.StoreMapper;
import com.prodmix.api.repositories.StoreRepository;
import com.prodmix.api.security.TokenService;
import com.prodmix.api.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;
    private final StoreMapper mapper;
    private final StoreRepository repository;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto body) {
        Store store = this.repository.findByEmail(body.email()).orElseThrow(
                () -> new StoreEmailNotFoundException(Errors.PSE102)
        );
        if (encoder.matches(body.password(), store.getPassword())) {
            String token = this.tokenService.generateToken(store);
            return ResponseEntity.ok(new ResponseDto(store.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(
            @Valid @RequestBody CreateStoreDto body
    ) {
        body.setPassword(encoder.encode(body.getPassword()));
        ResponseStoreDto store = service.register(body);
        Store registeredStore = mapper.responseStoreDTOToStore(store);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/stores/{slug}")
                .buildAndExpand(registeredStore.getSlug()).toUri();
        String token = this.tokenService.generateToken(registeredStore);
        ResponseDto response = new ResponseDto(registeredStore.getName(), token);
        return ResponseEntity.created(uri).body(response);
    }
}
