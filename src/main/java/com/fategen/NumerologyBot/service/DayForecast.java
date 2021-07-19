package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.DateValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DayForecast {

    private final String date;
    private final String interestingDate;

    public int calculate() {
        DateValidator.validate(date);
        DateValidator.validate(interestingDate);

        YearForecast yearForecast = new YearForecast(date, NumberUtils.getLocalDate(interestingDate).getYear());
        MonthForecast monthForecast = new MonthForecast(yearForecast, NumberUtils.getLocalDate(interestingDate).getMonthValue());

        return NumberUtils.sumOfDigitsCycler(NumberUtils.getLocalDate(interestingDate).getDayOfMonth() + monthForecast.calculate());
    }
}
