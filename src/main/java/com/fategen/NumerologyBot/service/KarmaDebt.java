package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.service.personAndMind.PersonNumber;
import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.DateValidator;
import com.fategen.NumerologyBot.validator.NameValidator;

import java.util.Set;

public class KarmaDebt {

    private Set<Integer> specialNums = Set.of(13, 14, 16, 19);
    private final String date;
    private final String fullName;

    public KarmaDebt(String date, String fullName) {
        this.date = date;
        this.fullName = fullName;
    }

    private int firstCheck() {
        if (specialNums.contains(NumberUtils.getLocalDate(date).getDayOfMonth())) {
            return 1;
        } else if (specialNums.contains(NumberUtils.sumOfDigits(NumberUtils.removePointsFromDate(date)))) {
            return 1;
        }
        return 0;
    }

    private int secondCheck() {
        if (specialNums.contains(NumberUtils.calculateSumOfDate(date))) {
            return 1;
        }
        return 0;
    }

    private int thirdCheck() {
        if (specialNums.contains(NumberUtils.calculateFullNameByPattern(fullName, PersonNumber.pattern, NameValidator.VOWEL_LETTERS))) {
            return 1;
        }
        return 0;
    }

    public String calculate() {
        DateValidator.validate(date);
        NameValidator.fioValidator(fullName);

        int result = 0;
        result += firstCheck();
        result += secondCheck();
        result += thirdCheck();

        return conclusion(result);
    }

    private String conclusion(int result) {
        if (result == 0) {
            return "Поздравляю, у Вас нет Кармического долга!";
        } else {
            return "";
        }
    }
}
