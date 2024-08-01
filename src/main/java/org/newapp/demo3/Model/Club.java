package org.newapp.demo3.Model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private String stadium;
    private String coach;
    private String league;
    private String country;

    @OneToMany(mappedBy = "club" ,cascade = CascadeType.REMOVE)
    Set<Player> players = new HashSet<>();
}
