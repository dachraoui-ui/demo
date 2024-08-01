package org.newapp.demo3.Repository;

import org.newapp.demo3.Model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ClubRepo extends JpaRepository<Club, Integer> {
    Optional<Club> findByName(String name);
    @Query("select c from Club c where c.name like concat('%',:query,'%')")
    List<Club> searchByName(String query);
}
