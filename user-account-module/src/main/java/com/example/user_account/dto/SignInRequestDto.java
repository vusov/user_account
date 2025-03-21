package com.example.user_account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Schema(description = "Запрос на аутентификацию")
public class SignInRequestDto {

    @Schema(description = "Имя пользователя", example = "Jon")
    @Size(min = 5, max = 50, message = "Email пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Email пользователя не может быть пустыми")
    private String email;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(min = 8, max = 255, message = "Длина пароля должна быть от 8 до 255 символов")
    @NotBlank(message = "Пароль не может быть пустыми")
    private String password;

}
