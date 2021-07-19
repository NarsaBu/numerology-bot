package com.fategen.NumerologyBot.service.compatibility.section;

public class SelfRatingInCouple implements CompatibilitySectionInterface {

    @Override
    public String calculate(int[][] userMatrix, int[][] partnerMatrix) {
        return conclusion(getValue(userMatrix), getValue(partnerMatrix));
    }

    private int getValue(int[][] userMatrix) {
        return (userMatrix[0][0] + userMatrix[1][0] + userMatrix[2][0]);
    }

    //TODO return norm value
    private String conclusion(int userResult, int partnerResult) {
        return String.valueOf(userResult);
    }
}
