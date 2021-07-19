package com.fategen.NumerologyBot.service.birthMeaning;

import com.fategen.NumerologyBot.service.birthMeaning.section.BirthDateMeaning;
import com.fategen.NumerologyBot.service.birthMeaning.section.BirthDateNumber;
import com.fategen.NumerologyBot.service.birthMeaning.section.BirthSectionInterface;
import com.fategen.NumerologyBot.service.birthMeaning.section.LifePathNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.fategen.NumerologyBot.validator.DateValidator.validate;

public class BirthMeaning {

    private String date;

    private final List<BirthSectionInterface> listOfImpl = List.of(
            new BirthDateMeaning(),
            new BirthDateNumber(),
            new LifePathNumber()
                                                                  );

    public BirthMeaning(String date) {
        this.date = date;
    }

    public List<String> calculate() {
        validate(date);

        var result = new ArrayList<String>();

        for (BirthSectionInterface service : listOfImpl) {
            result.add(service.calculate(date));
        }
        return result;
    }
}
