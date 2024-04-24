package com.codigotruko.taller2.services.implementations;

import com.codigotruko.taller2.domain.dtos.SaveUserDTO;
import com.codigotruko.taller2.domain.entities.User;
import com.codigotruko.taller2.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    public static final List<User> users = new ArrayList<>(Arrays.asList(
            new User("John", "12345678", LocalDate.now(), "John@Onichan.com", "user", false),
            new User("Jane", "12345678", LocalDate.now(),"Jane@Onichan.com", "user", false),
            new User("Poul", "12345678", LocalDate.now(),"Poul@Onichan.com", "user", false)
    ));

    @Override
    public void save(SaveUserDTO info){
        User user = this.findByUsername(info.getUsername());

        if(user == null){
            user = new User();
            users.add(user);
        }

        user.setUsername(info.getUsername());
        user.setPassword(info.getPassword());
        user.setEmail(info.getEmail());
    }

    @Override
    public List<User> findAll() {return users;}

    @Override
    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteByUsername(String username) {users.removeIf(user -> user.getUsername().equals(username));}

    @Override
    public void toggleActive(String username) {
        User user = findByUsername(username);

        if(user != null){
            user.setActive(!user.getActive());
        }
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        User user = findByUsername(username);

        if (user != null)
            user.setPassword(newPassword);
    }
}
