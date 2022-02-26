import main.Option;
import optional.task1.NumberUtils;
import optional.task2.MatrixUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Option OPTION = new Option();
    private static final MatrixUtils MATRIX_UTILS = new MatrixUtils();
    public static final NumberUtils NUMBER_UTILS = new NumberUtils();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int size = Integer.parseInt(reader.readLine());
//        int[][] matrix = MATRIX_UTILS.generateMatrix(size);
//        MATRIX_UTILS.printMatrix(matrix);
//        MATRIX_UTILS.task4(matrix);

//        List<String> numbers = new ArrayList<>();
//        while (true) {
//            String a = reader.readLine();
//            if (a.isBlank()) {
//                break;
//            }
//            numbers.add(a);
//        }
        reader.close();
//        NUMBER_UTILS.task1(numbers);

//       OPTION.reverseArgs(args);
    }
}
