package Stage_1;

import static Inputs.InputConsole.inputArray;

public class B02 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        //Наибольшее и наименьшее число.

        int max = nums[0];
        int min = nums[0];
        for (int elem : nums) {
            if (elem < min) min = elem;
            else if (elem > max) max = elem;
        }
        System.out.println("Max: " + max);
        System.out.println("Max: " + min);
    
    }
}
