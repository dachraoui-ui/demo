package org.newapp.demo3.DTO;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "don't put empty name ")
    private String name;
    private int age;
    private String Country ;

}
