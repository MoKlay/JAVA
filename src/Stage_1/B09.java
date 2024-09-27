package Stage_1;

import static Inputs.InputConsole.inputArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B09 {
    private static List<Integer> findHappyNumbers(int[] numbers) {
        List<Integer> happyNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (isHappyNumber(number)) {
                happyNumbers.add(number);
            }
        }
        return happyNumbers;
    }

    private static boolean isHappyNumber(int number) {
        Set<Integer> seen = new HashSet<>();
        while (number != 1 && !seen.contains(number)) {
            seen.add(number);
            number = getSumOfSquares(number);
        }
        return number == 1;
    }

    private static int getSumOfSquares(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = inputArray();
        //Отсортированные числа в порядке возрастания и убывания.
        List<Integer> happyNumbers = findHappyNumbers(nums);
        System.out.println("Счастливые числа из списка: " + happyNumbers);
    }
}
