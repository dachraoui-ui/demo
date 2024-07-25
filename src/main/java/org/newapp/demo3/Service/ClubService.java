package org.newapp.demo3.Service;

import org.newapp.demo3.DTO.ClubDTO;
import org.newapp.demo3.Model.Club;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ClubService{
    List<ClubDTO> findAllClubs();
    Club Save(Club club);
    ClubDTO findById(int id);
    void Update(ClubDTO club);
}
