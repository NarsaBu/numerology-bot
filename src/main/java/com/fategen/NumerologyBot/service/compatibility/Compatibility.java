package com.fategen.NumerologyBot.service.compatibility;

import com.fategen.NumerologyBot.service.compatibility.math.CompatibilityMath;
import com.fategen.NumerologyBot.service.compatibility.section.AffectionToFamily;
import com.fategen.NumerologyBot.service.compatibility.section.CompatibilitySectionInterface;
import com.fategen.NumerologyBot.service.compatibility.section.CouplePurpose;
import com.fategen.NumerologyBot.service.compatibility.section.CoupleSpirituality;
import com.fategen.NumerologyBot.service.compatibility.section.EverydayStability;
import com.fategen.NumerologyBot.service.compatibility.section.MaterialWelfare;
import com.fategen.NumerologyBot.service.compatibility.section.SelfRatingInCouple;
import com.fategen.NumerologyBot.service.compatibility.section.SexualCompatibility;
import com.fategen.NumerologyBot.service.compatibility.section.SpiritualCompatibility;
import com.fategen.NumerologyBot.service.compatibility.section.StabilityInCouple;

import java.util.ArrayList;
import java.util.List;

public class Compatibility {

    private String userDate;
    private String partnerDate;

    private int[][] userMatrix;
    private int[][] partnerMatrix;

    private final CompatibilityMath compatibilityMath = new CompatibilityMath();

    private final List<CompatibilitySectionInterface> listOfImpl = List.of(
            new EverydayStability(),
            new SpiritualCompatibility(),
            new CouplePurpose(),
            new AffectionToFamily(),
            new StabilityInCouple(),
            new SelfRatingInCouple(),
            new MaterialWelfare(),
            new SexualCompatibility(),
            new CoupleSpirituality()
                                                                          );

    public Compatibility(String userDate, String partnerDate) {
        this.userDate = userDate;
        this.partnerDate = partnerDate;
    }

    /** Калькулятор совместимости. Вызывает все необзодимые методы и выдает конечный результат
     *
     */
    public List<String> calculate() {
        userMatrix = compatibilityMath.calculateMatrix(userDate);
        partnerMatrix = compatibilityMath.calculateMatrix(partnerDate);

        var result = new ArrayList<String>();

        for(CompatibilitySectionInterface service : listOfImpl) {
            result.add(service.calculate(userMatrix, partnerMatrix));
        }

        for (int[] matrix : userMatrix) {
            for (int i : matrix) {
                System.out.printf("%5d", i);
            }
            System.out.println();
        }
        return result;
    }
}
