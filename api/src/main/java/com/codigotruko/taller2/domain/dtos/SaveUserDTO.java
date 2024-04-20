package com.codigotruko.taller2.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaveUserDTO {
    private String username;
    private String password;
    private String email;

}
