package com.fategen.NumerologyBot.service.compatibility.section;

public class SpiritualCompatibility implements CompatibilitySectionInterface {

    @Override
    public String calculate(int[][] userMatrix, int[][] partnerMatrix) {
        int userResult = getValue(userMatrix);
        int partnerResult = getValue(partnerMatrix);
        double resultValue = userResult * partnerResult / 365.0;

        return conclusion(userResult, partnerResult, resultValue);
    }

    private int getValue(int[][] userMatrix) {
        return (userMatrix[0][0] + userMatrix[1][1] + userMatrix[2][2])
                * (userMatrix[0][0] + userMatrix[1][0] + userMatrix[2][0])
                * (userMatrix[0][0] + userMatrix[0][1] + userMatrix[0][2]);
    }

    //TODO return norm value
    private String conclusion(int userResult, int partnerResult, double resultValue) {
        return String.valueOf(resultValue);
    }
}
