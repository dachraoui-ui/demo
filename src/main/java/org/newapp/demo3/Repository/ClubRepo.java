package org.newapp.demo3.Repository;

import org.newapp.demo3.Model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepo extends JpaRepository<Club, Integer> {

}
