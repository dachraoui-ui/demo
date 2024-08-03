package org.newapp.demo3.Repository;

import org.newapp.demo3.DTO.PlayerDto;
import org.newapp.demo3.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;




public interface PlayerRepo extends JpaRepository<Player, Integer> {

}
