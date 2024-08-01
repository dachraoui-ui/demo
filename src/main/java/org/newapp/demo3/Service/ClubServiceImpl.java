package org.newapp.demo3.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.newapp.demo3.DTO.ClubDTO;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Repository.ClubRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Builder
@AllArgsConstructor
public class ClubServiceImpl implements ClubService{

    private ClubRepo clubRepo;
    @Override
    public List<ClubDTO> findAllClubs() {
        List<Club> clubs = clubRepo.findAll();
        return clubs.stream().map(this::ClubToDTO).collect(Collectors.toList());
    }
    @Override
    public Club Save(Club club){
        return clubRepo.save(club);
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
    @Override
    public void Update(ClubDTO club){
        Club clubDto = updateToClub(club);
        clubRepo.save(clubDto);

    }
    private Club updateToClub(ClubDTO club){
        Club clubDTO = Club.builder().id(club.getId())
                .name(club.getName())
                .coach(club.getCoach())
                .location(club.getLocation())
                .country(club.getCountry())
                .league(club.getLeague())
                .stadium(club.getStadium()).build();
        return clubDTO;

    }
    public void delete(int ClubId){
        clubRepo.deleteById(ClubId);
    }

    @Override
    public List<ClubDTO> searchByName(String query) {
        List<Club> clubs = clubRepo.searchByName(query);
        return clubs.stream().map(this::ClubToDTO).collect(Collectors.toList());
    }
}
