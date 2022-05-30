package com.example.NationalEquestrianFederation.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationDto {

    private String username;
    private String password;

}
