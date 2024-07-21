package org.newapp.demo3.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.newapp.demo3.DTO.ClubDTO;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Repository.ClubRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Builder
@AllArgsConstructor
public class ClubServiceImpl implements ClubService{

    private ClubRepo clubRepo;
    @Override
    public List<Club> findAllClubs() {
        return clubRepo.findAll();
    }
    @Override
    public void Save(Club club){
        clubRepo.save(club);
    }
    @Override
    public ClubDTO findById(int id){
        Club club = clubRepo.findById(id).get();
        return ClubToDTO(club);
    }
    private ClubDTO ClubToDTO(Club club){
        ClubDTO clubDTO = ClubDTO.builder()
                .id(club.getId())
                .name(club.getName())
                .coach(club.getCoach())
                .location(club.getLocation())
                .country(club.getCountry())
                .league(club.getLeague())
                .stadium(club.getStadium()).build();
        return clubDTO;
    }
}
