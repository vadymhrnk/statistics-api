package com.example.statisticsapi.mapper;

import com.example.statisticsapi.config.MapperConfig;
import com.example.statisticsapi.document.User;
import com.example.statisticsapi.dto.internal.UserRegistrationRequestDto;
import com.example.statisticsapi.dto.internal.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto requestDto);
}
