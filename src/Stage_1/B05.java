package Stage_1;

import static Inputs.InputConsole.inputArray;

public class B05 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        //Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
        System.out.println("Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.");
        for (int el : nums) {
            if (el >= 100 && el < 1000) {
                int hundreds = el / 100;
                int tens = (el / 10) % 10;
                int units = el % 10;

                if (hundreds != tens && hundreds != units && tens != units) {
                    System.out.print(el + " ");
                }
            }
        }
    }
}
