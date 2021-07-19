package com.fategen.NumerologyBot.service.compatibility;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.fategen.NumerologyBot.util.NumberUtils.removePointsFromDate;
import static com.fategen.NumerologyBot.util.NumberUtils.sumOfDigitsCycler;
import static com.fategen.NumerologyBot.validator.DateValidator.validate;

@AllArgsConstructor
public class KarmaRelations {

    private final String userDate;
    private final String partnerDate;

    public List<Integer> calculate() {
        validate(userDate);
        validate(partnerDate);
        List<Integer> list = new ArrayList<>();
        list.add(sumOfDigitsCycler(removePointsFromDate(userDate)) + sumOfDigitsCycler(removePointsFromDate(partnerDate)));
        list.add(Math.abs(sumOfDigitsCycler(removePointsFromDate(userDate)) - sumOfDigitsCycler(removePointsFromDate(partnerDate))));
        return list;
    }
}
