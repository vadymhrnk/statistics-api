package com.example.statisticsapi.securtity;

import com.example.statisticsapi.dto.internal.UserLoginRequestDto;
import com.example.statisticsapi.dto.internal.UserLoginResponseDto;
import com.example.statisticsapi.exception.AuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private static final String LOGIN_ERROR_MESSAGE = "Can't log in: ";

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto)
            throws AuthenticationException {
        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestDto.getEmail(),
                            requestDto.getPassword()
                    )
            );

            String token = jwtUtil.generateToken(authentication.getName());
            return new UserLoginResponseDto(token);
        } catch (BadCredentialsException ex) {
            throw new AuthenticationException(LOGIN_ERROR_MESSAGE, ex);
        }
    }
}
