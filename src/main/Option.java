package main;

public class Option {

    private int[] parseToIntArray(String[] args) {
        int[] intArray = new int[args.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(args[i]);
        }
        return intArray;
    }

    public void sayHelloUser(String userName) {
        System.out.printf("Hello %s%n", userName);
    }

    public void reverseArgs(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }

    public void printRandomNumbers(String count) {
        int N = Integer.parseInt(count);
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 10);
        }

        for (int num : nums) {
            System.out.printf(" %d ", num);
        }
        System.out.println();

        for (int num : nums) {
            System.out.println(num);
        }

    }

    public void multiplyAndAddition(String[] args) {
        int[] nums = parseToIntArray(args);
        long addResult = 0;
        long mulResult = 1;

        for (int num : nums) {
            mulResult *= num;
            addResult += num;
        }

        System.out.printf("Addition result = %d%n" +
                "Multiply result = %d%n", addResult, mulResult);
    }

    public void nameMonth(String numberMonth) {
        int number = Integer.parseInt(numberMonth) - 1;

        if (number >= 0 && number < 12) {
            System.out.println(Month.values()[number]);
        } else {
            System.out.println("Incorrect number of month");
        }
    }
}
