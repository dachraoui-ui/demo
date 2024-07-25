package org.newapp.demo3.Repository;

import org.newapp.demo3.Model.Club;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClubRepo extends JpaRepository<Club, Integer> {

}
