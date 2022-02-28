package com.example.optional.task1;

import java.util.Comparator;
import java.util.List;

public class NumberUtils {

    public static void shortestAndLongestNumbers(List<Integer> numbers) {
        int shortestLength = getShortestLength(numbers);
        int longestLength = getLongestLength(numbers);

        for (Integer number : numbers) {
            if (intLength(number) == shortestLength) {
                System.out.printf("Короткое число %s : длина %d%n", number, shortestLength);
            } else if (intLength(number) == longestLength) {
                System.out.printf("Длинное число %s : длина %d%n", number, longestLength);
            }
        }
    }

    public static void sortByNumberLength(List<Integer> numbers) {
        numbers.stream()
                .sorted(Comparator.comparingInt(NumberUtils::intLength))
                .forEach(System.out::println);
    }

    public static void numbersLessAverageLength(List<Integer> strings) {
        double averageLength = getAverageLengthNumber(strings);

        for (Integer num : strings) {
            if (intLength(num) < averageLength) {
                System.out.printf("Число %s : длина %d\n", num, intLength(num));
            }
        }
    }

    public static double getAverageLengthNumber(List<Integer> numbers) {
        return (double) getSumNumberLengths(numbers) / numbers.size();
    }

    public static int getLongestLength(List<Integer> numbers) {
        Integer longestNumber = numbers.stream()
                .max(Comparator.comparingInt(NumberUtils::intLength))
                .orElseThrow();

        return intLength(longestNumber);
    }

    public static int getShortestLength(List<Integer> numbers) {
        Integer shortestNumber = numbers.stream()
                .min(Comparator.comparingInt(NumberUtils::intLength))
                .orElseThrow();

        return intLength(shortestNumber);
    }

    public static int getSumNumberLengths(List<Integer> numbers) {
        return numbers.stream().mapToInt(NumberUtils::intLength).sum();
    }

    public static int intLength(Integer number) {
        return number != 0 ? (int) Math.ceil(Math.log10(Math.abs(number) + 0.5)) : 1;
    }
}

