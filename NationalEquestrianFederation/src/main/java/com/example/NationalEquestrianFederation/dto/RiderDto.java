package com.example.NationalEquestrianFederation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto {

    private String name;

    private String surname;

    private String dateOfBirth;

    private String gender;

    private String licence;

    private Integer ownerId;

}
