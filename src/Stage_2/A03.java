package Stage_2;

import Inputs.InputConsole;

import java.util.ArrayList;
import java.util.List;

public class A03 {
    public static void main(String[] args) {
        int[] nums = InputConsole.inputArray();
        int sum = 0;
        for (int i : nums) {
            sum += String.valueOf(i).length();
        }
        sum /= nums.length;
        System.out.println("Средняя длина числа = " + sum);
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        for (int i : nums) {
            if (String.valueOf(i).length() < sum) {
                min.add(i);
            }
            else if (String.valueOf(i).length() > sum) {
                max.add(i);
            }
        }
        
    }
}
