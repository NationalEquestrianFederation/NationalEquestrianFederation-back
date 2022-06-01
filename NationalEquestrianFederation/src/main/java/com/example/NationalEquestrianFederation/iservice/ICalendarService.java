package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.dto.DateDto;

import java.util.List;

public interface ICalendarService {

    List<DateDto> getDatesOfMonth(Integer month, Integer year);

}
