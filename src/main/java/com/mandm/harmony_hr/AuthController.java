package com.mandm.harmony_hr;

import com.mandm.harmony_hr.dto.JwtResponse;
import com.mandm.harmony_hr.dto.LoginRequest;
import com.mandm.harmony_hr.dto.MessageResponse;
import com.mandm.harmony_hr.dto.SignupRequest;
import com.mandm.harmony_hr.entities.Users;
import com.mandm.harmony_hr.mappers.SignupUserMapper;
import com.mandm.harmony_hr.models.Roles;
import com.mandm.harmony_hr.repositories.EmployeeRepository;
import com.mandm.harmony_hr.repositories.UsersRepository;
import com.mandm.harmony_hr.utils.JwtUtils;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager,
                          UsersRepository usersRepository,
                          PasswordEncoder passwordEncoder,
                            EmployeeRepository employeeRepository,
                          JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.employeeRepository = employeeRepository;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Users user = (Users) authentication.getPrincipal();
        String jwt = jwtUtils.generateToken(user.getUsername(), user.getAccessRights().name());

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (usersRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        Users user = SignupUserMapper.toEntity(signUpRequest, passwordEncoder, employeeRepository);
        usersRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}