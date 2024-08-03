package org.newapp.demo3.Repository;

import org.newapp.demo3.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
   UserEntity findByEmail(String email);
   UserEntity findByUsername(String username);
}
