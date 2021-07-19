package com.fategen.NumerologyBot.service.compatibility;

import lombok.AllArgsConstructor;

import static com.fategen.NumerologyBot.util.NumberUtils.removePointsFromDate;
import static com.fategen.NumerologyBot.util.NumberUtils.sumOfDigitsCycler;
import static com.fategen.NumerologyBot.validator.DateValidator.validate;

@AllArgsConstructor
public class MyDestiny {

    private final String userDate;
    private final String partnerDate;

    public int calculate() {
        validate(userDate);
        validate(partnerDate);
        return sumOfDigitsCycler(removePointsFromDate(userDate)) + sumOfDigitsCycler(removePointsFromDate(partnerDate));
    }
}
