package org.newapp.demo3.Service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.newapp.demo3.DTO.RegistrationDTO;
import org.newapp.demo3.Model.Role;
import org.newapp.demo3.Model.RoleEnum;
import org.newapp.demo3.Model.UserEntity;
import org.newapp.demo3.Repository.RoleRepo;
import org.newapp.demo3.Repository.UserRepo;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    public UserRepo userRepo;
    public RoleRepo roleRepo;

    @Override
    public void saveUser(RegistrationDTO registrationDTO) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        Role role = roleRepo.findRoleByName(String.valueOf(RoleEnum.USER));
        user.setRoles(Arrays.asList(role));
        userRepo.save(user);
    }

    @Override
    public UserEntity FindByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
