package org.newapp.demo3.Repository;

import org.newapp.demo3.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findRoleByName(String name);
}
