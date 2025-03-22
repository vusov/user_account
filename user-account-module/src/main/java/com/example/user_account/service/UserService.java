package com.example.user_account.service;

import com.example.user_account.model.User;
import com.example.user_account.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Page<User> findUsers(LocalDate dateOfBirth, String phone, String name, String email, Pageable pageable) {
        Specification<User> spec = Specification.where(null);
        if (dateOfBirth != null) {
            spec = spec.and((user, cq, cb) -> cb.greaterThanOrEqualTo(user.get("u.dateOfBirth"), dateOfBirth));
        }
        if (phone != null) {
            spec = spec.and((user, cq, cb) -> cb.equal(user.get("p.phoneNumber"), phone));
        }
        if (name != null) {
            spec = spec.and((user, cq, cb) -> cb.like(user.get("u.name"), name + "%"));
        }
        if (email != null) {
            spec = spec.and((user, cq, cb) -> cb.equal(user.get("e.email"), email));
        }
        return userRepository.findUsers(spec, pageable);
    }

    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    public User getByUsername(String username) {
        return userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }

    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    public User getUserOnEmail(String email) {
        return userRepository.findOnEmail(email).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

}
