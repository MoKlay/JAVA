package Stage_1;
import static Inputs.InputConsole.inputArray;
import java.util.Arrays;

public class B01 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        //Четные и нечетные числа.

        System.out.println("Введенные числа: " + Arrays.toString(nums));
        System.out.print("Четные числа:   ");
        for (int elem : nums) if (elem % 2 == 0) System.out.print(elem + " ");
        System.out.print("\nНечетные числа: ");
        for (int elem : nums) if (elem % 2 != 0) System.out.print(elem + " ");
        
    }
}
