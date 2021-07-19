package com.fategen.NumerologyBot.service.compatibility.section;

public class SexualCompatibility implements CompatibilitySectionInterface {

    @Override
    public String calculate(int[][] userMatrix, int[][] partnerMatrix) {
        return conclusion(getValue(userMatrix), getValue(partnerMatrix));
    }

    private int getValue(int[][] userMatrix) {
        return (userMatrix[2][0] + userMatrix[1][1] + userMatrix[0][2]);
    }

    //TODO return norm value
    private String conclusion(int userResult, int partnerResult) {
        return String.valueOf(userResult);
    }
}
