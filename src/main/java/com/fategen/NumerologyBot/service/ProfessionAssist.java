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

        while (num / 10 != 0) {
            num = NumberUtils.sumOfDigits(num);
            if (num == 11 || num == 22) {
                break;
            }
        }

        return String.valueOf(num);
    }
}
