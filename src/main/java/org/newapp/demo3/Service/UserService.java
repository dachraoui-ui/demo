package org.newapp.demo3.Service;

import org.newapp.demo3.DTO.RegistrationDTO;
import org.newapp.demo3.Model.UserEntity;

public interface UserService {
    void saveUser(RegistrationDTO registrationDTO);
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
