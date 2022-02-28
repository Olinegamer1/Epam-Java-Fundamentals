package com.example.optional.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserUtils {
    public static List<Integer> parseToInt(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();
        strings.stream()
                .filter(ParserUtils::isNumber)
                .mapToInt(Integer::parseInt)
                .forEach(numbers::add);
        return numbers;
    }

    public static int[] parseToInt(String[] strings) {
        return Arrays.stream(strings)
                .filter(ParserUtils::isNumber)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
