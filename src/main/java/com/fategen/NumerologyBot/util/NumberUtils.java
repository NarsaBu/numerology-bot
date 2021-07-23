package com.fategen.NumerologyBot.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtils {

    /** Сумма цифр числа
     *
     * @param num - число
     */
    public static int sumOfDigits(int num) {
        int result = 0;

        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    /** Удаляет точки из даты и переводит ее в инт
     *
     * @param date - дата
     * @return возвращает дату без точек в инте
     */
    public static int removePointsFromDate(String date) {
        return Integer.parseInt(date.replaceAll("\\.", ""));
    }

    /** Делает цикл из сумм цифр до тех пор, пока число не будет однозначным
     *
     * @param num - число
     * @return - возвращает однозначное число
     */
    public static int sumOfDigitsCycler(int num) {
        while (num / 10 != 0) {
            num = sumOfDigits(num);
        }
        return num;
    }

    /** Повторяет функционал метода sumOfDigitsCycler.
     * Если после итерации получилось число 11 или 22, то возвращает эти числа
     *
     * @param num - число
     * @return - возвращает однозначное число
     */
    public static int sumOfDigitsCyclerWithoutElevenAndTwelve(int num) {
        while (num / 10 != 0) {
            num = sumOfDigits(num);
            if (num == 11 || num == 22) {
                break;
            }
        }
        return num;
    }

    /** Получить дату в формате LocalDate
     *
     * @param date - дата в строковом формате
     * @return LocalDate
     */
    public static LocalDate getLocalDate(String date) {
        List<Integer> dateComponents = Arrays.stream(date.split("\\."))
                                             .map(Integer::parseInt)
                                             .collect(Collectors.toList());

        return LocalDate.of(dateComponents.get(2), dateComponents.get(1), dateComponents.get(0));
    }

    /** Получает число по имени и паттерну
     *
     * @param name - имя
     * @param pattern - паттерн, по которому производятся вычисления
     * @param letterType - тип букв (гласные, согласные, все вместе)
     * @return возвращает однозначную сумму цифр числа
     */
    public static int calculateNameByPattern(String name, List<String> pattern, String letterType) {
        int result = 0;
        char[] arr = name.toLowerCase().toCharArray();

        for (char letter : arr) {
            if (letterType.contains(String.valueOf(letter))) {
                for (String element : pattern) {
                    if (element.contains(String.valueOf(letter))) {
                        result += pattern.indexOf(element) + 1;
                    }
                }
            }
        }
        return sumOfDigitsCycler(result);
    }

    /** calculateNameByPattern для ФИО
     *
     * @param fullName - ФИО
     * @param pattern - паттерн по которому осуществляется алгоритм
     * @param letterType - тип букв (гласные, согласные, все вместе)
     * @return возвращает однозначную сумму цифр числа
     */
    public static int calculateFullNameByPattern(String fullName, List<String> pattern, String letterType) {
        List<String> list = Arrays.stream(fullName.split(" ")).collect(Collectors.toList());
        int result = 0;

        for (String element : list) {
            result += NumberUtils.calculateNameByPattern(element, pattern, letterType);
        }

        return result;
    }

    /** Сумма элементов даты. Каждый элемент проходится по алгоритму "Сумма цифр числа" (sumOfDigits)
     *
     * @param date - дата
     * @return возвращает сумму элементов даты
     */
    public static int calculateSumOfDate(String date) {
        LocalDate separatedDate = NumberUtils.getLocalDate(date);
        int result = NumberUtils.sumOfDigitsCycler(separatedDate.getDayOfMonth());
        result += NumberUtils.sumOfDigitsCycler(separatedDate.getMonthValue());
        result += NumberUtils.sumOfDigitsCycler(separatedDate.getYear());

        return result;
    }
}
