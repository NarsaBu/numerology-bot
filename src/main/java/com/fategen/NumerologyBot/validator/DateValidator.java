package com.fategen.NumerologyBot.validator;

import com.fategen.NumerologyBot.exception.IllegalDateException;

import java.time.LocalDate;
import java.time.OffsetDateTime;
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

        if (dateComponents.get(2) < OffsetDateTime.now().getYear()) {
            throw new IllegalDateException("year of birth is higher than current");
        }

        if (OffsetDateTime.now().getYear() - dateComponents.get(2) < 15) {
            throw new IllegalDateException("year of birth is too low");
        }
    }
}
