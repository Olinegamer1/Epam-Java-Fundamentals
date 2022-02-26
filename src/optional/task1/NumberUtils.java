package optional.task1;

import java.util.Comparator;
import java.util.List;

public class NumberUtils {
    private boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int getIntLength(String num) {
        return num.startsWith("-") ? num.length() - 1 : num.length();
    }

    public void task1(List<String> numbers) {
        int shortestLength = Integer.MAX_VALUE;
        int longestLength = Integer.MIN_VALUE;

        for (String num : numbers) {
            if (isNumber(num)){
                shortestLength = Math.min(shortestLength, getIntLength(num));
                longestLength = Math.max(longestLength, getIntLength(num));
            }
        }

        for (String num : numbers) {
            if (getIntLength(num) == shortestLength) {
                System.out.printf("Короткое число %s : длина %d\n", num, shortestLength);
            } else if (getIntLength(num) == longestLength) {
                System.out.printf("Длинное число %s : длина %d\n", num, longestLength);
            }
        }
    }

    public void task2(List<String> numbers) {
        numbers.stream()
                .filter(this::isNumber)
                .sorted(Comparator.comparingInt(this::getIntLength))
                .forEach(System.out::println);
    }

    public void task3(List<String> numbers) {
        double avgLength = 0;

        int countNums = 0;
        for (String num : numbers) {
            if (isNumber(num)) {
                avgLength += getIntLength(num);
                countNums++;
            }
        }
        avgLength /= countNums;

        for (String num : numbers) {
            if (isNumber(num) && getIntLength(num) < avgLength) {
                System.out.printf("Число %s : длина %d\n", num, getIntLength(num));
            }
        }


    }
}

