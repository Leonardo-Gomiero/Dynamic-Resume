package com.bigodebombado.backend.Model.User;

public record RegisterDTO(String firstName, String lastName, String email, String password, String exp1, String empresa1, String period1, String exp2, String empresa2, String period2, String exp3, String empresa3, String period3, String acaTit1, String acaCon1, String acaTit2, String acaCon2, String  lan1, String lanLv1, String lan2, String lanLv2, String hardSkl1, String hardSkl2, String hardSkl3, String softSkl1, String softSkl2, String softSkl3, UserRole role) {
}
