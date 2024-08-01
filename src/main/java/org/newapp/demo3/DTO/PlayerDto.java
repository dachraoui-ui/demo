package org.newapp.demo3.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor

public class PlayerDto {
    private int id;
    private String name;
    private int age;
    private String Country ;

}
