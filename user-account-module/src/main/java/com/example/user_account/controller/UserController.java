package com.example.user_account.controller;

import com.example.user_account.model.User;
import com.example.user_account.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(@DateTimeFormat(pattern = "yyyy-MM-dd")
                                          @RequestParam(required = false) LocalDate dateOfBirth,
                                      @RequestParam(required = false) String phone,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) String email,
                                      Pageable pageable) {
        Page<User> users = userService.findUsers(dateOfBirth, phone, name, email, pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping
    @Operation(summary = "Доступен только авторизованным пользователям")
    public String example() {
        return "Hello, world!";
    }
}
