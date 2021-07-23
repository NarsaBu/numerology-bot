package com.fategen.NumerologyBot.service;

import com.fategen.NumerologyBot.service.compatibility.math.CompatibilityMath;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PartnerAssist {

    private String date;

    public String calculate() {
        int[][] matrix = new CompatibilityMath().calculateMatrix(date);

        int collectorOfOne = matrix[0][0];
        int collectorOfTwo = matrix[1][0];

        return collectorOfOne + " " + collectorOfTwo;
    }
}
