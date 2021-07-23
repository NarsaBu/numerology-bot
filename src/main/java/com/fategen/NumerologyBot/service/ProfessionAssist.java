package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.DateValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProfessionAssist {

    private String date;

    public String calculate() {
        DateValidator.validate(date);

        int num = NumberUtils.removePointsFromDate(date);

        return String.valueOf(NumberUtils.sumOfDigitsCyclerWithoutElevenAndTwelve(num));
    }
}
