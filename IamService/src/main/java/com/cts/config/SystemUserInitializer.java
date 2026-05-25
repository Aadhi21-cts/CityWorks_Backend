package com.cts.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cts.entity.User;
import com.cts.repository.UserRepository;

@Configuration
public class SystemUserInitializer {

    @Bean
    CommandLineRunner initSystemUsers(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {
            createIfNotExists(userRepository, passwordEncoder, "system_admin", "ADMIN", "admin@gmail.com");
            createIfNotExists(userRepository, passwordEncoder, "system_supervisor", "SUPERVISOR", "supervisor@gmail.com");
            createIfNotExists(userRepository, passwordEncoder, "system_auditor", "AUDITOR", "auditor@gmail.com");

            if (userRepository.findByUsername("worker2").isEmpty()) {
                User worker = new User();
                worker.setUsername("worker2");
                worker.setName("Worker Two");
                worker.setPassword(passwordEncoder.encode("worker123")); 
                worker.setRole("WORKER");
                worker.setStatus("ACTIVE");
                worker.setEmail("worker2@gmail.com"); 
                userRepository.save(worker);
                System.out.println("Worker Two created successfully!");
            }
        };
    }

    private void createIfNotExists(
            UserRepository repository,
            PasswordEncoder encoder,
            String username,
            String role,
            String email) {

        if (repository.findByUsername(username).isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setName(username);
            
            user.setPassword(encoder.encode("admin123")); 
            
            user.setRole(role);
            user.setStatus("ACTIVE");
            user.setEmail(email);
            repository.save(user);
            System.out.println(role + " created successfully with password 'admin123'!");
        }
    }
}