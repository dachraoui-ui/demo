package org.newapp.demo3.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.newapp.demo3.DTO.PlayerDto;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Model.Player;
import org.newapp.demo3.Repository.ClubRepo;
import org.newapp.demo3.Repository.PlayerRepo;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService{
    private PlayerRepo playerRepo;
    private ClubRepo clubRepo;
    @Override
    public void createPlayer(int clubId, PlayerDto playerDTO) {
       Club club = clubRepo.findById(clubId).get();
        Player player = maptoPlayer(playerDTO);
        player.setClub(club);
        playerRepo.save(player);
    }

    public Player maptoPlayer(PlayerDto playerDto){
        return Player.builder()
                .id(playerDto.getId())
                .age(playerDto.getAge())
                .name(playerDto.getName())
                .Country(playerDto.getCountry())
                .build();
    }
}
