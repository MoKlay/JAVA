package Stage_2;

import Inputs.InputConsole;
import java.util.Collections;
import java.util.List;

public class A01 {
    public static void main(String[] args) {
        List<Integer> nums = InputConsole.inputList();
        System.out.println("Длинное число: " + Collections.max(nums));
        System.out.println("Короткое число: " + Collections.min(nums));
    }
}
