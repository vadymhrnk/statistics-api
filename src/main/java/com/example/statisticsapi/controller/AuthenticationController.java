package com.example.statisticsapi.controller;

import com.example.statisticsapi.dto.internal.UserLoginRequestDto;
import com.example.statisticsapi.dto.internal.UserLoginResponseDto;
import com.example.statisticsapi.dto.internal.UserRegistrationRequestDto;
import com.example.statisticsapi.dto.internal.UserResponseDto;
import com.example.statisticsapi.exception.AuthenticationException;
import com.example.statisticsapi.exception.RegistrationException;
import com.example.statisticsapi.securtity.AuthenticationService;
import com.example.statisticsapi.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication manager", description = "Endpoint to authenticate users")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register a new user", description = "Register a new user")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    @Operation(
            summary = "Login using existing credentials",
            description = "Login using existing credentials"
    )
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto)
            throws AuthenticationException {
        return authenticationService.authenticate(requestDto);
    }
}
