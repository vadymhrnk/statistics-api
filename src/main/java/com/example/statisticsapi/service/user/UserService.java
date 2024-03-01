package com.example.statisticsapi.service.user;

import com.example.statisticsapi.dto.internal.UserRegistrationRequestDto;
import com.example.statisticsapi.dto.internal.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto);
}
