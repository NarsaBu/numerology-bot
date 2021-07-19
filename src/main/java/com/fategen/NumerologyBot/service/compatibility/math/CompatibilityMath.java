package com.fategen.NumerologyBot.service.compatibility.math;

import org.springframework.stereotype.Service;

import static com.fategen.NumerologyBot.util.NumberUtils.removePointsFromDate;
import static com.fategen.NumerologyBot.util.NumberUtils.sumOfDigits;
import static com.fategen.NumerologyBot.util.NumberUtils.sumOfDigitsCycler;
import static com.fategen.NumerologyBot.validator.DateValidator.validate;

@Service
public class CompatibilityMath {

    /** Считает значение третьего числа дч
     *
     * @param firstDch - первое ДЧ
     * @param date - дата рождения
     * @return fourthDate
     */
    private int calculateThirdDch(int firstDch, String date) {
        int thirdDch;

        if (date.charAt(0) == '0') { //если число начинается с 0 (01), то пропускаем ноль
            thirdDch = Integer.parseInt(String.valueOf(date.charAt(1)));
        } else {
            thirdDch = Integer.parseInt(String.valueOf(date.charAt(0)));
        }

        thirdDch = firstDch - thirdDch * 2;

        return thirdDch > 0 ? thirdDch : -thirdDch;
    }

    /** Создание матрицы со значениями
     *
     * @param collector - строка включает в себя все числа ДЧ и дату раождения
     * @return matrix
     */
    private int[][] matrixCreation(String collector) {
        int[] collection = collector.replaceAll("\\.", "")
                                    .chars()
                                    .map(Character::getNumericValue)
                                    .toArray(); //делаем массив из цифр

        int[][] matrix = new int[3][3];

        int x = 1; //начинаем заполнение с цифры 1

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int value : collection) { //ищем все значения в collection
                    if (value == x) {
                        matrix[i][j] += 1;
                    }

                }
                x += 1;
            }
        }
        return matrix;
    }

    /** Транспонированная матрица
     *
     * @param matrix - матрица
     * @return transposition matrix
     */
    private int[][] matrixTransposition(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    public int[][] calculateMatrix(String date) {
        validate(date);
        int firstDch = sumOfDigits(removePointsFromDate(date));
        int secondDch = sumOfDigits(firstDch);
        int thirdDch = calculateThirdDch(firstDch, date);
        int fourthDch = sumOfDigitsCycler(thirdDch);
        int[][] matrix = matrixCreation(date + firstDch + secondDch + thirdDch + fourthDch);
        return matrixTransposition(matrix);
    }
}
