package com.fategen.NumerologyBot.validator;

import com.fategen.NumerologyBot.exception.IllegalNameException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameValidator {

    public static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String CONSONANT_LETTERS = "БВГДЖЗЙКЛМНПРСТФХЧЦШЩбвгджзйклмнпрстфхчцшщ";
    public static final String VOWEL_LETTERS = "АЕЁИОУЫЭЮЯаеёиоуыэюя";

    public static void nameValidator(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }

        char[] arr = name.toCharArray();

        for (char letter : arr) {
            if (!(ALPHABET.contains(String.valueOf(letter)))) {
                throw new IllegalNameException("name is not valid");
            }
        }
    }

    public static void fioValidator(String fio) {
        List<String> list = Arrays.stream(fio.split(" ")).collect(Collectors.toList());
        for (String element : list) {
            nameValidator(element);
        }
    }
}
