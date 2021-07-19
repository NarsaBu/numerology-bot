package com.fategen.NumerologyBot.service.compatibility;

import com.fategen.NumerologyBot.util.NumberUtils;
import com.fategen.NumerologyBot.validator.NameValidator;

import java.util.List;

public class CompatibilityAndKarmaRelations {

    private final List<String> pattern = List.of("дэип", "касъ", "нре", "ёьбй", "оючт", "явхл", "зцщы", "умш", "гфж");
    private final String userFullName;
    private final String partnerFullName;

    public CompatibilityAndKarmaRelations(String userFullName, String partnerFullName) {
        this.userFullName = userFullName;
        this.partnerFullName = partnerFullName;
    }

    public int calculate() {
        NameValidator.fioValidator(userFullName);
        NameValidator.fioValidator(partnerFullName);

        int result;

        result = NumberUtils.calculateNameByPattern(userFullName, pattern, NameValidator.ALPHABET);
        result *= NumberUtils.calculateNameByPattern(partnerFullName, pattern, NameValidator.ALPHABET);
        result += 7;
        result = NumberUtils.sumOfDigitsCycler(result);

        return result;
    }
}
