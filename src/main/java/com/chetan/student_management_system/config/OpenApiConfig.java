package com.chetan.student_management_system.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Student Management System API",
                version = "1.0",
                description = "REST API for managing student records",
                contact = @Contact(
                        name = "Chetan Kumar",
                        email = "ck95263@gmail.com"
                )
        )
)
public class OpenApiConfig {
}