package org.newapp.demo3.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Repository.ClubRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Builder
@AllArgsConstructor
public class ClubServiceImpl implements ClubService{

    private ClubRepo clubRepo;
    @Override
    public List<Club> findAllClubs() {
        return clubRepo.findAll();
    }
}
