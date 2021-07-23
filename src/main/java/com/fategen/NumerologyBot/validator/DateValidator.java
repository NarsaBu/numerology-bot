package com.fategen.NumerologyBot.validator;

import com.fategen.NumerologyBot.exception.IllegalDateException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DateValidator {

    /** Проверяет дату на валидность
     *
     */
    public static void validate(String date) {
        List<Integer> dateComponents = Arrays.stream(date.split("\\."))
                                             .map(Integer::parseInt)
                                             .collect(Collectors.toList());
        try {
            LocalDate.of(dateComponents.get(2), dateComponents.get(1), dateComponents.get(0));
        } catch (IllegalDateException e) {
            e.printStackTrace();
        }
    }
}
