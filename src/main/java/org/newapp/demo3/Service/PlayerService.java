package org.newapp.demo3.Service;

import org.newapp.demo3.DTO.PlayerDto;
import org.newapp.demo3.Model.Player;

import java.util.List;


public interface PlayerService {
    //List<PlayerDto> findAllPlayer();
    void createPlayer(int clubId, PlayerDto playerDto);
}
