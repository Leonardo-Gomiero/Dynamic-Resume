package com.bigodebombado.backend.Model.User;

public record RegisterDTO(String firstName, String lastName, String email, String password, String exp1, String empresa1, String period1, String exp2, String empresa2, String period2, String exp3, String empresa3, String period3, UserRole role) {
}
