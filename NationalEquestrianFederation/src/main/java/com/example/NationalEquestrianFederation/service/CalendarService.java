package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.dto.DateDto;
import com.example.NationalEquestrianFederation.iservice.ICalendarService;
import com.example.NationalEquestrianFederation.model.Competition;
import com.example.NationalEquestrianFederation.repository.ICompetitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.YearMonth;
import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class CalendarService implements ICalendarService {

    private ICompetitionRepository competitionRepository;

    @Override
    public List<DateDto> getDatesOfMonth(Integer month, Integer year) {
        List<DateDto> dates = new ArrayList<>();
        setDatesOfPreviousMonth(month - 1, year, dates);
        setDatesOfPresentMonth(month, year, dates);
        setDatesOfFollowingMonth(month + 1, year, dates);
        return dates;
    }

    private void setDatesOfPreviousMonth(Integer month, Integer year, List<DateDto> dates) {
        Integer numberOfDates = getNumberOfDaysOfPreviousMonth(month + 1, year);
        if(month == 0) {    //month of previous year
            month = 12;
            year--;
        }
        int numberOfDatesInMonth = YearMonth.of(year, month + 1).lengthOfMonth();   //months start from 1
        for(int i = 0; i < numberOfDates; i++) {
            String date = year.toString() + '-' + (month + 1) + '-' + numberOfDatesInMonth;
            date = correctDate(date, year, month, numberOfDatesInMonth);
            dates.add(new DateDto(date, getCompetitionsByDate(date)));
            numberOfDatesInMonth--;
        }
        Collections.reverse(dates);
    }

    private Integer getNumberOfDaysOfPreviousMonth(Integer month, Integer year) {
        int firstDayOfMonth = new Date(year, month, 1).getDay();
        int numberOfDays = firstDayOfMonth - 2;
        if (numberOfDays == -1) numberOfDays = 6; //if Sunday
        return  numberOfDays;
    }

    private void setDatesOfPresentMonth(Integer month, Integer year, List<DateDto> dates){
        int numberOfDatesInMonth = YearMonth.of(year, month + 1).lengthOfMonth();
        for(int i = 1; i <= numberOfDatesInMonth; i++) {
            String date = year.toString() + '-' + (month + 1) + '-' + i;
            date = correctDate(date, year, month, i);
            dates.add(new DateDto(date, getCompetitionsByDate(date)));
        }
    }

    private String correctDate(String fullDate, int year, int month, int date) {
        if(month < 9) {
            fullDate = year + "-0" + (month + 1) + '-' + date;
        }
        if(date < 10) {
            fullDate = year + "-" + (month + 1) + "-0" + date;
        }
        if(month < 9 && date < 10) {
            fullDate = year + "-0" + (month + 1) + "-0" + date;
        }
        return fullDate;
    }

    private void setDatesOfFollowingMonth(Integer month, Integer year, List<DateDto> dates) {
        int numberOfDays = 42 - dates.size();
        for(int i = 1; i <= numberOfDays; i++) {
            if (month == 13)    //month in next year
            {
                month = 1;
                year++;
            }
            String date = year.toString() + '-' + (month + 1) + '-' + i;
            date = correctDate(date, year, month, i);
            dates.add(new DateDto(date, getCompetitionsByDate(date)));
        }
    }

    private List<String> getCompetitionsByDate(String date) {
        List<String> competitions = new ArrayList<>();
        List<Competition> competitionsOnDate = competitionRepository.getCompetitionsByDate(date);
        if(!competitionsOnDate.isEmpty()) {
            for (Competition competition : competitionsOnDate) {
                competitions.add(competition.getDiscipline().toString());
            }
        }
        return competitions;
    }

}
