package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.service.personAndMind.PersonNumber;
import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.NameValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Talents {

    private final String fullName;

    public int calculate() {
        NameValidator.fioValidator(fullName);

        int result = NumberUtils.calculateFullNameByPattern(fullName, PersonNumber.pattern, NameValidator.ALPHABET);
        result = NumberUtils.sumOfDigitsCycler(result);

        return result;
    }
}
