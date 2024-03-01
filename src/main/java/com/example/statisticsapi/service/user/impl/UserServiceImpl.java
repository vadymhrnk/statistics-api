package com.example.statisticsapi.service.user.impl;

import com.example.statisticsapi.document.Role;
import com.example.statisticsapi.document.User;
import com.example.statisticsapi.dto.internal.UserRegistrationRequestDto;
import com.example.statisticsapi.dto.internal.UserResponseDto;
import com.example.statisticsapi.exception.RegistrationException;
import com.example.statisticsapi.mapper.UserMapper;
import com.example.statisticsapi.repository.RoleRepository;
import com.example.statisticsapi.repository.UserRepository;
import com.example.statisticsapi.service.user.UserService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String REGISTER_ERROR_MESSAGE = "Can't register a new user with email: ";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(REGISTER_ERROR_MESSAGE + requestDto.getEmail()
            );
        }
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        Role userRole = roleRepository.findByRoleName(Role.RoleName.USER);
        User user = userMapper.toModel(requestDto);
        user.setRoles(Set.of(userRole));
        return userMapper.toDto(userRepository.save(user));
    }
}
