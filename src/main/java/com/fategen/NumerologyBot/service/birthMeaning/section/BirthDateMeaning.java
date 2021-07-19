package com.fategen.NumerologyBot.service.birthMeaning.section;

import com.fategen.NumerologyBot.maps.BirthDateMap;

import static com.fategen.NumerologyBot.util.NumberUtils.getLocalDate;

public class BirthDateMeaning implements BirthSectionInterface {

    public String calculate(String date) {
        int result = getLocalDate(date).getDayOfMonth();

        //TODO put result into config file
        return "Значение даты рождения:\n" + BirthDateMap.birthDateMap.get(String.valueOf(result));
    }
}
