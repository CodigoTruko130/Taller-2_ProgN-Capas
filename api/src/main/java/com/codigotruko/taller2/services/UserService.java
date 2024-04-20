package com.codigotruko.taller2.services;

import com.codigotruko.taller2.domain.dtos.SaveUserDTO;
import com.codigotruko.taller2.domain.entities.User;

import java.util.List;

public interface UserService {
    void save(SaveUserDTO info);
    List<User> findAll();
    User findByUsername(String username);
    void deleteByUsername(String username);
}
