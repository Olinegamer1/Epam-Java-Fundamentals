package com.example;

import com.example.optional.task1.NumberUtils;
import com.example.optional.task1.ParserUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> strings = new ArrayList<>();
        while (true) {
            String a = reader.readLine();
            if (a.isBlank()) {
                break;
            }
            strings.add(a);
        }
        reader.close();

        List<Integer> numbers = ParserUtils.parseToInt(strings);
        NumberUtils.numbersLessAverageLength(numbers);
    }
}
