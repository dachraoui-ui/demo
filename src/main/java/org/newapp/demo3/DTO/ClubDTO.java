package org.newapp.demo3.DTO;

import lombok.Builder;
import lombok.Data;
import org.newapp.demo3.Model.Club;

@Data
@Builder
public class ClubDTO {
    private int id;
    private String name;
    private String location;
    private String stadium;
    private String coach;
    private String league;
    private String country;
    public ClubDTO ClubToDTO(Club club){
        ClubDTO clubDTO = ClubDTO.builder()
                .id(club.getId())
                .name(club.getName())
                .coach(club.getCoach())
                .location(club.getLocation())
                .country(club.getCountry())
                .league(club.getLeague())
                .stadium(club.getStadium()).build();
    }
}
