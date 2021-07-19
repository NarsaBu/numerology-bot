package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.DateValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MythicalAbility {

    private final String date;

    
    public int calculate() {
        DateValidator.validate(date);

        return NumberUtils.sumOfDigitsCycler(NumberUtils.calculateSumOfDate(date));
    }
}
