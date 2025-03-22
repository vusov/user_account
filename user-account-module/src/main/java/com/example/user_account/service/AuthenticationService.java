package com.example.user_account.service;

import com.example.user_account.dto.JwtAuthenticationResponse;
import com.example.user_account.dto.SignInRequestDto;
import com.example.user_account.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    /**
     * Аутентификация пользователя
     *
     * @param authRequest данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(@NonNull SignInRequestDto authRequest) {
        final User user = userService.getUserOnEmail(authRequest.getEmail());
        if (user.getPassword().equals(authRequest.getPassword())) {
            var jwt = jwtService.generateToken(user);
            return new JwtAuthenticationResponse(jwt);
        } else {
            throw new RuntimeException("Неправильный пароль");
        }
    }
}
