package com.example;

import com.example.optional.task1.ParserUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Option {

    public static void sayHelloUser(String userName) {
        System.out.println("Hello " + userName);
    }

    public static void reverseArgs(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }

    public static void printRandomNumbers(String amount) {
        if (ParserUtils.isNumber(amount)) {
            int size = Integer.parseInt(amount);
            int[] numbers = createIntArray(size);

            System.out.println(Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));

            Arrays.stream(numbers).forEach(System.out::println);
        }
    }

    public static void multiplyAndAddition(String[] args) {
        int[] numbers = ParserUtils.parseToInt(args);
        System.out.printf("Addition result = %d%n" +
                "Multiply result = %d%n", getSum(numbers), getMultiply(numbers));
    }

    public static void nameMonth(String numberMonth) {
        if (ParserUtils.isNumber(numberMonth)) {
            int number = Integer.parseInt(numberMonth) - 1;
            if (number >= 0 && number < 12) {
                System.out.println(Month.values()[number]);
            } else {
                System.out.println("Incorrect number of month");
            }
        }
    }

    public static int getMultiply(int[] numbers) {
        return Arrays.stream(numbers)
                .reduce((first, second) -> first * second)
                .orElseThrow();
    }

    public static int getSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static int[] createIntArray(int size) {
        return new Random().ints(size).toArray();
    }
}
