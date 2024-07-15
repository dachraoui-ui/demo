package org.newapp.demo3.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Repository.ClubRepo;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
public class ClubServiceImpl implements ClubService{

    private ClubRepo clubRepo;

    @Override
    public List<Club> FindAllClub() {
       List<Club> clubs = clubRepo.findAll();
       return clubs.stream().map((club)->ClubToDTO(club)).collect(Collectors.toList());
    }
}
