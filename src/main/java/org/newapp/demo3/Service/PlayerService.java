package org.newapp.demo3.Service;

import org.newapp.demo3.DTO.PlayerDto;


public interface PlayerService {
    void createPlayer(int clubId, PlayerDto playerDto);
}
