package com.imt.framework.com.Uber.service;

import com.imt.framework.com.Uber.model.User;
import com.imt.framework.com.Uber.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServices userServices;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setEmail("existing@example.com");
        user.setPassword("correctpassword");
        user.setCrousCardBalance(10.0);
    }

    @Test
    void whenCreateUserThenSuccess() {
        when(userRepository.findByEmail("new@example.com")).thenReturn(Optional.empty());

        userServices.createUser("new@example.com", "New", "User", "newpassword");

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void whenCreateUserWithExistingEmailThenException() {
        when(userRepository.findByEmail("existing@example.com")).thenReturn(Optional.of(user));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userServices.createUser("existing@example.com", "Existing", "User", "password");
        });

        assertEquals("Le compte existe déjà", exception.getMessage());
    }

    @Test
    void givenValidCredentialsWhenSignInThenSuccess() {
        when(userRepository.findByEmail("existing@example.com")).thenReturn(Optional.of(user));

        boolean isLoggedIn = userServices.signIn("existing@example.com", "correctpassword");

        assertTrue(isLoggedIn);
    }

    @Test
    void givenInvalidPasswordWhenSignInThenFail() {
        when(userRepository.findByEmail("existing@example.com")).thenReturn(Optional.of(user));

        boolean isLoggedIn = userServices.signIn("existing@example.com", "wrongpassword");

        assertFalse(isLoggedIn);
    }

    @Test
    void givenNonExistentUserWhenSignInThenFail() {
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        boolean isLoggedIn = userServices.signIn("nonexistent@example.com", "anyPassword");

        assertFalse(isLoggedIn);
    }

    @Test
    void givenValidCredentialsAndAmountWhenRechargerCarteThenSuccess() {
        when(userRepository.findByEmail("existing@example.com")).thenReturn(Optional.of(user));

        userServices.rechargerCarte("existing@example.com", "correctpassword", 20.0);

        assertEquals(30.0, user.getCrousCardBalance());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void givenInvalidPasswordWhenRechargerCarteThenFail() {
        when(userRepository.findByEmail("existing@example.com")).thenReturn(Optional.of(user));

        userServices.rechargerCarte("existing@example.com", "wrongpassword", 20.0);

        assertEquals(10.0, user.getCrousCardBalance());
        verify(userRepository, times(0)).save(any(User.class)); // Ensure no save operation was called
    }

    @Test
    void givenNonExistentUserWhenRechargerCarteThenFail() {
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        userServices.rechargerCarte("nonexistent@example.com", "anyPassword", 20.0);

        verify(userRepository, times(0)).save(any(User.class));
    }
}