package com.anke.service;

import com.anke.dto.request.CreateUserRequestDto;
import com.anke.dto.request.LoginResponseDto;
import com.anke.dto.request.RegisterRequestDto;
import com.anke.entity.Auth;
import com.anke.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;

    public Auth register(RegisterRequestDto dto) {
        Auth auth = repository.save(Auth.builder()
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                .build());
        return auth;
    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
