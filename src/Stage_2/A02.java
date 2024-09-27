package Stage_2;

import Inputs.InputConsole;
import java.util.Collections;
import java.util.List;

public class A02 {
    public static void main(String[] args) {
        List<Integer> list = InputConsole.inputList();
        Collections.sort(list);
        System.out.println("В порядке возрастания: " + list);
        Collections.reverse(list);
        System.out.println("В порядке убывания: " + list);
    }
}
