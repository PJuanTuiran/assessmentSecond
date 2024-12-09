package com.riwi.assessment_appointment.controllers.impl;

import com.riwi.assessment_appointment.controllers.interfaces.IAuthController;
import com.riwi.assessment_appointment.models.DTOs.request.LoginRequest;
import com.riwi.assessment_appointment.models.DTOs.request.RegistreRequest;
import com.riwi.assessment_appointment.models.entities.UserEntity;
import com.riwi.assessment_appointment.services.interfaces.IModelAuth;
import com.riwi.assessment_appointment.utils.enums.Roles;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController implements IAuthController {

    @Autowired
    IModelAuth authService;
    @Operation(
            summary = "Admin Registration",
            description = "Register a new user with Administrator privileges. This endpoint is used to create an Admin user by submitting the required user details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Admin user successfully registered."),
            @ApiResponse(responseCode = "400", description = "Invalid input data. Ensure all required fields are provided and valid."),
            @ApiResponse(responseCode = "409", description = "A user with the provided email already exists."),
    })
    @PostMapping("/adminRegister")
    @Override
    public ResponseEntity<?> registerAdmin(@RequestBody @Valid RegistreRequest registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO, Roles.ADMIN));
    }

    @Operation(
            summary = "Patient Registration",
            description = "Register a new Carrier user. This endpoint is used to register a user who will act as a Carrier in the system. The request body must contain all necessary user details, such as name, email, and password."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Patient user successfully registered."),
            @ApiResponse(responseCode = "400", description = "Invalid input data. Ensure the request body meets the required validation rules."),
            @ApiResponse(responseCode = "409", description = "A user with the provided email already exists.")
    })
    @PostMapping("/patientRegister")
    @Override
    public ResponseEntity<?> registerPatient(@RequestBody @Valid RegistreRequest registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO,Roles.PATIENT));

    }

    @Operation(
            summary = "Doctor Registration",
            description = "Register a new Carrier user. This endpoint is used to register a user who will act as a Carrier in the system. The request body must contain all necessary user details, such as name, email, and password."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Doctor user successfully registered."),
            @ApiResponse(responseCode = "400", description = "Invalid input data. Ensure the request body meets the required validation rules."),
            @ApiResponse(responseCode = "409", description = "A user with the provided email already exists.")
    })
    @PostMapping("/doctorRegister")
    @Override
    public ResponseEntity<?> registerDoctor(@RequestBody @Valid RegistreRequest registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO,Roles.PATIENT));
    }

    @Operation(
            summary = "User Login",
            description = "Authenticate a user with valid credentials. Submit the user's email and password to obtain an authentication token. This token can be used for accessing other secured endpoints."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful. Returns an authentication token."),
            @ApiResponse(responseCode = "400", description = "Invalid credentials provided. Ensure the email and password are correct."),
            @ApiResponse(responseCode = "404", description = "User not found with the provided email.")
    })
    @PostMapping("/login")
    @Override
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequestDTO));
    }

    @Operation(
            summary = "Obtener todos los usuarios",
            description = "Este endpoint devuelve una lista con todos los usuarios registrados en el sistema.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de usuarios obtenida exitosamente.",
                            content = @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = UserEntity.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno en el servidor."
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<UserEntity>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(authService.readAll());
    }
}
