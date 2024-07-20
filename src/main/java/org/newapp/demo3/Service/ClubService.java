package org.newapp.demo3.Service;

import org.hibernate.annotations.SecondaryRow;
import org.newapp.demo3.Model.Club;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClubService{
    List<Club> findAllClubs();
    Club Save(Club club);
}
