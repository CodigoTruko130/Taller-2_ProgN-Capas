package com.codigotruko.taller2.domain.dtos;

import lombok.Data;

@Data
public class AuthSigninResponseDTO {
    private String username;
    private String email;
    private String rol;
}
