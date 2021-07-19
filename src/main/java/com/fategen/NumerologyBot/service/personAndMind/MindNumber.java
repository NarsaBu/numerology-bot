package com.fategen.NumerologyBot.service.personAndMind;

import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.DateValidator;
import com.fategen.NumerologyBot.validator.NameValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MindNumber {

    private final String name;
    private final String date;

    public int calculate() {
        NameValidator.nameValidator(name);
        DateValidator.validate(date);

        int result;
        result = NumberUtils.calculateNameByPattern(name, PersonNumber.pattern, NameValidator.ALPHABET);
        result += NumberUtils.sumOfDigitsCycler(NumberUtils.getLocalDate(date).getDayOfMonth());
        result = NumberUtils.sumOfDigitsCycler(result);

        return result;
    }
}
