package Stage_2;

import java.util.Arrays;
import java.util.Scanner;

public class Option_A {

    public static void main(String[] args) {
        // Фамилия разработчика, дата и время получения задания
        System.out.println("Разработчик: Цыренов Чингис");
        System.out.println("Дата и время получения задания: 10.10.2023 12:00");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество чисел n: ");
            int n = scanner.nextInt();

            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Введите %d-е число: ", i + 1);
                numbers[i] = scanner.next();
            }

            // Дата и время сдачи задания
            System.out.println("\nДата и время сдачи задания: 11.10.2023 14:30\n");

            // Задача 1: Найти самое короткое и самое длинное число
            findShortestAndLongest(numbers);

            // Задача 2: Упорядочить и вывести числа в порядке возрастания (убывания)
            // значений их длины
            sortByLength(numbers);

            // Задача 3: Вывести на консоль те числа, длина которых меньше (больше) средней,
            // а также длину
            printNumbersWithLessOrMoreThanAverageLength(numbers);

            // Задача 4: Найти число, в котором число различных цифр минимально
            findNumberWithMinimalUniqueDigits(numbers);

            // Задача 5: Найти количество чисел, содержащих только четные цифры, а среди них
            // — количество чисел с равным числом четных и нечетных цифр
            countEvenDigitNumbers(numbers);

            // Задача 6: Найти число, цифры в котором идут в строгом порядке возрастания
            findIncreasingOrderNumber(numbers);

            // Задача 7: Найти число, состоящее только из различных цифр
            findDistinctDigitNumber(numbers);

            // Задача 8: Найти второй палиндром среди чисел
            findSecondPalindrome(numbers);

            // Задача 9: Найти корни квадратного уравнения
            solveQuadraticEquation(args);
        }
    }

    /**
     * Задача 1: Найти самое короткое и самое длинное число
     */
    private static void findShortestAndLongest(String[] numbers) {
        if (numbers.length == 0)
            return;

        String shortest = numbers[0], longest = numbers[0];
        for (String number : numbers) {
            if (number.length() < shortest.length()) {
                shortest = number;
            }
            if (number.length() > longest.length()) {
                longest = number;
            }
        }

        System.out.println("Самое короткое число: " + shortest + " (" + shortest.length() + ")");
        System.out.println("Самое длинное число: " + longest + " (" + longest.length() + ")\n");
    }

    /**
     * Задача 2: Упорядочить и вывести числа в порядке возрастания (убывания)
     * значений их длины
     */
    private static void sortByLength(String[] numbers) {
        Arrays.sort(numbers, (a, b) -> a.length() - b.length());
        System.out.println("Отсортированные числа по длине:");
        for (String number : numbers) {
            System.out.println(number);
        }
        System.out.println();
    }

    /**
     * Задача 3: Вывести на консоль те числа, длина которых меньше (больше) средней,
     * а также длину
     */
    private static void printNumbersWithLessOrMoreThanAverageLength(String[] numbers) {
        double averageLength = Arrays.stream(numbers).mapToInt(String::length).average().orElse(0.0);
        System.out.println("Средняя длина чисел: " + averageLength);

        System.out.println("Числа с длиной меньше средней:");
        for (String number : numbers) {
            if (number.length() < averageLength) {
                System.out.println(number + " (" + number.length() + ")");
            }
        }

        System.out.println("\nЧисла с длиной больше средней:");
        for (String number : numbers) {
            if (number.length() > averageLength) {
                System.out.println(number + " (" + number.length() + ")");
            }
        }
        System.out.println();
    }

    /**
     * Задача 4: Найти число, в котором число различных цифр минимально
     */
    private static void findNumberWithMinimalUniqueDigits(String[] numbers) {
        if (numbers.length == 0)
            return;

        String result = numbers[0];
        int minUniqueCount = getUniqueDigitCount(result);

        for (int i = 1; i < numbers.length; i++) {
            int uniqueCount = getUniqueDigitCount(numbers[i]);
            if (uniqueCount < minUniqueCount) {
                minUniqueCount = uniqueCount;
                result = numbers[i];
            }
        }

        System.out.println("Число с минимальным количеством уникальных цифр: " + result + "\n");
    }

    private static int getUniqueDigitCount(String number) {
        boolean[] digits = new boolean[10]; // Массив для отслеживания встречавшихся цифр
        for (char c : number.toCharArray()) {
            digits[c - '0'] = true;
        }

        int count = 0;
        for (boolean digit : digits) {
            if (digit)
                count++;
        }

        return count;
    }

    /**
     * Задача 5: Найти количество чисел, содержащих только четные цифры, а среди них
     * — количество чисел с равным числом четных и нечетных цифр
     */
    private static void countEvenDigitNumbers(String[] numbers) {
        int evenOnlyCount = 0;
        int equalCount = 0;

        for (String number : numbers) {
            boolean allEven = true;
            int evenCount = 0, oddCount = 0;

            for (char c : number.toCharArray()) {
                int digit = c - '0';
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                    allEven = false;
                }
            }

            if (allEven) {
                evenOnlyCount++;
                if (evenCount == oddCount) {
                    equalCount++;
                }
            }
        }

        System.out.println("Количество чисел, содержащих только четные цифры: " + evenOnlyCount);
        System.out.println("Среди них количество чисел с равным числом четных и нечетных цифр: " + equalCount + "\n");
    }

    /**
     * Задача 6: Найти число, цифры в котором идут в строгом порядке возрастания
     */
    private static void findIncreasingOrderNumber(String[] numbers) {
        String result = null;

        for (String number : numbers) {
            char prev = number.charAt(0);
            boolean increasing = true;

            for (int i = 1; i < number.length(); i++) {
                if (prev >= number.charAt(i)) {
                    increasing = false;
                    break;
                }
                prev = number.charAt(i);
            }

            if (increasing) {
                result = number;
                break;
            }
        }

        if (result != null) {
            System.out.println("Первое число с цифрами в строго возрастающем порядке: " + result + "\n");
        } else {
            System.out.println("Нет чисел с цифрами в строго возрастающем порядке.\n");
        }
    }

    /**
     * Задача 7: Найти число, состоящее только из различных цифр
     */
    private static void findDistinctDigitNumber(String[] numbers) {
        String result = null;

        for (String number : numbers) {
            boolean[] digits = new boolean[10];
            boolean distinct = true;

            for (char c : number.toCharArray()) {
                if (digits[c - '0']) {
                    distinct = false;
                    break;
                }
                digits[c - '0'] = true;
            }

            if (distinct) {
                result = number;
                break;
            }
        }

        if (result != null) {
            System.out.println("Первое число, состоящее только из различных цифр: " + result + "\n");
        } else {
            System.out.println("Нет чисел, состоящих только из различных цифр.\n");
        }
    }

    /**
     * Задача 8: Найти второй палиндром среди чисел
     */
    private static void findSecondPalindrome(String[] numbers) {
        int palindromeCount = 0;
        String secondPalindrome = null;

        for (String number : numbers) {
            if (isPalindrome(number)) {
                palindromeCount++;
                if (palindromeCount == 2) {
                    secondPalindrome = number;
                    break;
                }
            }
        }

        if (secondPalindrome != null) {
            System.out.println("Второй палиндром: " + secondPalindrome + "\n");
        } else {
            System.out.println("Второго палиндрома нет.\n");
        }
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Задача 9: Найти корни квадратного уравнения
     */
    private static void solveQuadraticEquation(String[] args) {
        if (args.length != 3) {
            System.out.println("Недостаточно параметров для решения квадратного уравнения.");
            return;
        }

        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Корни квадратного уравнения: x1 = " + root1 + ", x2 = " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                System.out.println("Квадратное уравнение имеет один корень: x = " + root);
            } else {
                System.out.println("Квадратное уравнение не имеет действительных корней.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка при преобразовании аргументов в числа.");
        }
    }
}
