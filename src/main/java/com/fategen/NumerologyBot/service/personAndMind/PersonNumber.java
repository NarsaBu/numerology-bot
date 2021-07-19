package com.fategen.NumerologyBot.service.personAndMind;

import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.NameValidator;

import java.util.List;

public class PersonNumber {

    public static List<String> pattern = List.of("аисъ", "бйты", "вкуь", "глфэ", "дмхю", "енця", "ёоч", "жпш", "зрщ");
    private final String fullName;

    public PersonNumber(String fullName) {
        this.fullName = fullName;
    }

    public int calculate() {
        NameValidator.fioValidator(fullName);

        int result = NumberUtils.calculateFullNameByPattern(fullName, pattern, NameValidator.CONSONANT_LETTERS);
        result = NumberUtils.sumOfDigitsCycler(result);

        return result;
    }
}
