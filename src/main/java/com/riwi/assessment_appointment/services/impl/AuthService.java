package com.riwi.assessment_appointment.services.impl;

import com.riwi.assessment_appointment.mappers.UserMapper;
import com.riwi.assessment_appointment.models.DTOs.request.LoginRequest;
import com.riwi.assessment_appointment.models.DTOs.request.RegistreRequest;
import com.riwi.assessment_appointment.models.DTOs.response.LoginResponse;
import com.riwi.assessment_appointment.models.DTOs.response.RegistreResponse;
import com.riwi.assessment_appointment.models.entities.UserEntity;
import com.riwi.assessment_appointment.repositories.UserRepository;
import com.riwi.assessment_appointment.services.interfaces.IModelAuth;
import com.riwi.assessment_appointment.utils.enums.Roles;
import com.riwi.assessment_appointment.utils.helpers.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService implements IModelAuth {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserMapper userMapper;
    @Override
    public RegistreResponse register(RegistreRequest registerRequestDTO, Roles role) {


        UserEntity user = userRepository.findByUsername(registerRequestDTO.getUsername());
        if(user != null){
            throw new IllegalArgumentException("User already exists");
        }

        UserEntity userSave = userMapper.registerRequestDTOToUserEntity(registerRequestDTO);
        userSave.setUsername(registerRequestDTO.getUsername());
        userSave.setRoles(role);
        userSave.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        userSave.setEmail(registerRequestDTO.getEmail());

        userRepository.save(userSave);

        return RegistreResponse.builder()
                .message("user created")
                .username(registerRequestDTO.getUsername())
                .role(role)
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequestDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(authentication.isAuthenticated()){
            UserEntity user = userRepository.findByUsername(loginRequestDTO.getUsername());
            LoginResponse loginResponseDTO = LoginResponse.builder()
                    .message("Login successful")
                    .role(user.getRoles())
                    .token(jwtService.getToken(user))
                    .build();

            return loginResponseDTO;
        }
        throw new RuntimeException("invalid credentials");

    }

    @Override
    public List<UserEntity> readAll() {
        List<UserEntity>user = userRepository.findAll();

        if(user.isEmpty()){
            throw new RuntimeException("users not found");
        }

        return user;

    }
}
