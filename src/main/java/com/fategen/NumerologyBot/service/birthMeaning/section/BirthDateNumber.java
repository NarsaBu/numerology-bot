package com.fategen.NumerologyBot.service.birthMeaning.section;

import static com.fategen.NumerologyBot.util.NumberUtils.getLocalDate;
import static com.fategen.NumerologyBot.util.NumberUtils.sumOfDigitsCycler;

public class BirthDateNumber implements BirthSectionInterface {

    public String calculate(String date) {
        int result = sumOfDigitsCycler(getLocalDate(date).getDayOfMonth());

        return "Число даты рождения:\n" + result;
    }
}
