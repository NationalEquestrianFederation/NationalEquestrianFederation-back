package com.example.NationalEquestrianFederation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DateDto {

    private String date;
    private List<String> competitions;

}
