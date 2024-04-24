package com.codigotruko.taller2.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private LocalDate fechaContratacion;
    private String email;
    private String rol;
    private Boolean active;
}
