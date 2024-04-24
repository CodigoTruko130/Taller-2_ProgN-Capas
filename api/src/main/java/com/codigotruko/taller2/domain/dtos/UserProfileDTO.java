package com.codigotruko.taller2.domain.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserProfileDTO {
    private String username;
    private String email;
    private LocalDate fechaContratacion;
    private String rol;
}
