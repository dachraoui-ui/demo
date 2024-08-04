package org.newapp.demo3.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    private int id;
    @NotBlank(message = "you should put a username")
    private String username;
    @NotBlank(message = "you should put an email")
    private String email ;
    @NotBlank(message = "you should put a password")
    private String password;
}
