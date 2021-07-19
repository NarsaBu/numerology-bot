package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.util.NumberUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MonthForecast {

    private final YearForecast yearForecast;
    private final int month;

    public int calculate() {
        if (!(month >= 1 && month <= 12)) {
            throw new IllegalArgumentException("month doesn`t exist");
        }

        return NumberUtils.sumOfDigitsCycler(yearForecast.calculate() + month);
    }
}
