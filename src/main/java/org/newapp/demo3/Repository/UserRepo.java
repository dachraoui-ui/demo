package org.newapp.demo3.Repository;

import org.newapp.demo3.Model.UserEntity;

public interface UserRepo {
   UserEntity findByEmail(String email);
   UserEntity findByUsername(String username);
}
