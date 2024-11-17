package org.buccodev.controller.dto;

import java.time.LocalDate;

public record UserResponseDto(String name, String email, String cpf, LocalDate birthday) {
}
