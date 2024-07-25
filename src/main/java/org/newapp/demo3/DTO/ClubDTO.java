package org.newapp.demo3.DTO;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDTO {
    private int id;
    @NotEmpty(message = "the name of club should not be empty")
    private String name;
    private String location;
    private String stadium;
    private String coach;
    @NotBlank(message = "the club should has a league")
    private String league;
    private String country;
}
