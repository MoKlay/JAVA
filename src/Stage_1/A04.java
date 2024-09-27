package Stage_1;
import java.util.Scanner;

public class A04 {
    public static void main(String[] args) {
        //Ввести пароль из командной строки и сравнить его со строкой-образцом.
        try (Scanner scan = new Scanner(System.in)) {
            String pass = "qwerty";
            System.out.print("Введите пароль: ");
            System.out.println("Вывод: " + Boolean.toString(scan.next().equals(pass)));
        }
    }
}
