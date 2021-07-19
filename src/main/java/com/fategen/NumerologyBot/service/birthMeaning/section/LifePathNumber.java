package com.fategen.NumerologyBot.service.birthMeaning.section;

import static com.fategen.NumerologyBot.util.NumberUtils.removePointsFromDate;
import static com.fategen.NumerologyBot.util.NumberUtils.sumOfDigits;
import static com.fategen.NumerologyBot.util.NumberUtils.sumOfDigitsCycler;

public class LifePathNumber implements BirthSectionInterface {

    public String calculate(String date) {
        int result = sumOfDigits(removePointsFromDate(date));

        if (result == 11 || result == 22) {
            result = sumOfDigits(removePointsFromDate(date));
        } else {
            result = sumOfDigitsCycler(removePointsFromDate(date));
        }

        //TODO get norm result
        return "Число жизненного пути:\n" + result;
    }
}
