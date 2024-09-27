package Stage_1;
import static Inputs.InputConsole.inputArray;

import java.math.BigInteger;

public class B06 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        //Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
        System.out.println("Простые числа.");
            
        for (int elem : nums) {
            if (BigInteger.valueOf(elem).isProbablePrime((int) Math.log(elem))) {
                System.out.println(elem);
            }
        }
    }
}
