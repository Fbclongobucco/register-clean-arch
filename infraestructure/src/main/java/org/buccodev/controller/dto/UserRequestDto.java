package org.buccodev.controller.dto;

import java.time.LocalDate;

public record UserRequestDto(String name, String email, String cpf, String password, LocalDate birthday) {
}
