package org.newapp.demo3.Service;

import org.newapp.demo3.DTO.ClubDTO;
import org.newapp.demo3.Model.Club;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClubService{
    List<Club> findAllClubs();
    void Save(Club club);
    ClubDTO findById(int id);
}
