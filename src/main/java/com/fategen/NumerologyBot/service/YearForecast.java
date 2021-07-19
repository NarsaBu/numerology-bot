package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.DateValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class YearForecast {

    private final String date;
    private final int year;

    public int calculate() {
        DateValidator.validate(date);
        if (year - 1 == Integer.MAX_VALUE || year + 1 == Integer.MIN_VALUE) {
            throw new ArithmeticException("int overflow");
        }

        int result;

        result = NumberUtils.sumOfDigitsCycler(NumberUtils.getLocalDate(date).getDayOfMonth());
        result += NumberUtils.sumOfDigitsCycler(NumberUtils.getLocalDate(date).getMonthValue());
        result += NumberUtils.sumOfDigitsCycler(year);
        result = NumberUtils.sumOfDigitsCycler(result);

        return result;
    }
}
