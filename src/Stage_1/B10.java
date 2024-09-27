package Stage_1;

import static Inputs.InputConsole.inputArray;

public class B10 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        //Отсортированные числа в порядке возрастания и убывания.
        for (int el : nums) {
            String str = String.valueOf(el);
            String reverse = new StringBuilder(str).reverse().toString();
            if (str.equals(reverse)){
                System.out.println(el);
            }
        }
    }
}
