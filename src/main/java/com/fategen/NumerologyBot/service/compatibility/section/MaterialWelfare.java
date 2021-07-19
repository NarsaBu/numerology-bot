package com.fategen.NumerologyBot.service.compatibility.section;

public class MaterialWelfare implements CompatibilitySectionInterface {

    @Override
    public String calculate(int[][] userMatrix, int[][] partnerMatrix) {
        return conclusion(getValue(userMatrix), getValue(partnerMatrix));
    }

    private int getValue(int[][] userMatrix) {
        return (userMatrix[0][1] + userMatrix[1][1] + userMatrix[2][1]);
    }

    //TODO return norm value
    private String conclusion(int userResult, int partnerResult) {
        return String.valueOf(userResult);
    }
}
