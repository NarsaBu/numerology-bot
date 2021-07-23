package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.DateValidator;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@AllArgsConstructor
public class CvAssistAndInterviewDate {

    private String date;
    private String interviewDate;

    public String calculate() {
        DateValidator.validate(date);
        DateValidator.validate(interviewDate);

        int num = NumberUtils.removePointsFromDate(date);
        num = NumberUtils.sumOfDigitsCycler(num);

        int interviewNum = NumberUtils.sumOfDigitsCycler(Integer.parseInt(changeYearToCurrent()));
        LocalDate localDate = NumberUtils.getLocalDate(interviewDate);
        interviewNum = NumberUtils.sumOfDigitsCycler(interviewNum + localDate.getMonthValue());
        interviewNum = NumberUtils.sumOfDigitsCycler(interviewNum + localDate.getDayOfMonth());

        return num + " " + interviewNum;
    }

    private String changeYearToCurrent() {
        LocalDate localDate = NumberUtils.getLocalDate(date);
        return localDate.getDayOfMonth()
                + String.valueOf(localDate.getMonthValue())
                + OffsetDateTime.now().getYear();
    }
}
