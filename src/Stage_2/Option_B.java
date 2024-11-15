package Stage_2;

import java.util.Scanner;

public class Option_B {

    public static void main(String[] args) throws InterruptedException {
        // Фамилия разработчика, дата и время получения задания
        System.out.println("Разработчик: Цыренов Чингис");
        System.out.println("Дата и время получения задания: 15.09.2023 18:00");

        try (Scanner scanner = new Scanner(System.in)) {
            // Задача 1: Таблица умножения
            multiplicationTable();
            Thread.sleep(1000);

            // Задача 2: Элементы массива в обратном порядке
            reverseArray(new int[] { 1, 2, 3, 4, 5 });
            Thread.sleep(1000);

            // Задача 3: Принадлежность значения k интервалам
            intervalBelonging(scanner);
            Thread.sleep(1000);

            // Задача 4: Числа от 1 до 100, делящиеся на 3
            divisibleByThree();
            Thread.sleep(1000);

            // Задача 5: Значащие нули в двоичной записи числа 129
            significantZeros(129);
            Thread.sleep(1000);

            // Задача 6: Основание системы счисления
            baseOfNumeralSystem();
            Thread.sleep(1000);

            // Задача 7: Перевод из десятичной системы в любую другую
            decimalToAnyBaseConversion(scanner);
            Thread.sleep(1000);

            // Задача 8: Перевод между произвольными системами счисления
            anyBaseToAnyBaseConversion(scanner);
            Thread.sleep(1000);

            // Задача 9: Название месяца по номеру
            monthNameByNumber(scanner);
            Thread.sleep(1000);

        }

        // Дата и время сдачи задания
        System.out.println("\nДата и время сдачи задания: 16.09.2023 20:00");
    }

    /**
     * Задача 1: Вывести на экран таблицу умножения.
     */
    private static void multiplicationTable() {
        System.out.println("\nТаблица умножения:");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j); // Форматируем вывод для выравнивания
            }
            System.out.println();
        }
    }

    /**
     * Задача 2: Вывести элементы массива в обратном порядке.
     *
     *
     */
    private static void reverseArray(int[] array) {
        System.out.println("\nЭлементы массива в обратном порядке:");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Задача 3: Определить принадлежность некоторого значения k интервалам (n, m],
     * [n, m), (n, m), [n, m].
     *
     * 
     */
    private static void intervalBelonging(Scanner scanner) {
        System.out.println("\nОпределение принадлежности значения k интервалам:");
        System.out.print("Введите значение k: ");
        int k = scanner.nextInt();
        System.out.print("Введите границы интервала n и m: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        if (k > n && k <= m) {
            System.out.println("(n, m]: Да");
        } else {
            System.out.println("(n, m]: Нет");
        }

        if (k >= n && k < m) {
            System.out.println("[n, m): Да");
        } else {
            System.out.println("[n, m): Нет");
        }

        if (k > n && k < m) {
            System.out.println("(n, m): Да");
        } else {
            System.out.println("(n, m): Нет");
        }

        if (k >= n && k <= m) {
            System.out.println("[n, m]: Да");
        } else {
            System.out.println("[n, m]: Нет");
        }
    }

    /**
     * Задача 4: Вывести на экран все числа от 1 до 100, которые делятся на 3 без
     * остатка.
     */
    private static void divisibleByThree() {
        System.out.println("\nЧисла от 1 до 100, делящиеся на 3 без остатка:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    /**
     * Задача 5: Сколько значащих нулей в двоичной записи числа 129?
     *
     *
     */
    private static void significantZeros(int num) {
        System.out.println("\nЗначащие нули в двоичной записи числа 129:");
        String binary = Integer.toBinaryString(num);
        int zeros = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                zeros++;
            }
        }
        System.out.println(zeros);
    }

    /**
     * Задача 6: В системе счисления с некоторым основанием десятичное число 81
     * записывается в виде 100. Найти это основание.
     */
    private static void baseOfNumeralSystem() {
        System.out.println("\nОснование системы счисления, в которой 81 записывается как 100:");
        int base = 0;
        while (true) {
            base++;
            if (Math.pow(base, 2) == 81) {
                break;
            }
        }
        System.out.println(base);
    }

    /**
     * Задача 7: Перевод из десятичной системы в любую другую.
     *
     * 
     */
    private static void decimalToAnyBaseConversion(Scanner scanner) {
        System.out.println("\nПеревод из десятичной системы в любую другую:");
        System.out.print("Введите десятичное число: ");
        int decNumber = scanner.nextInt();
        System.out.print("Введите основание новой системы счисления: ");
        int newBase = scanner.nextInt();

        String convertedNumber = "";
        while (decNumber > 0) {
            int remainder = decNumber % newBase;

            switch (remainder) {
                case 10 -> convertedNumber = "A" + convertedNumber;
                case 11 -> convertedNumber = "B" + convertedNumber;
                case 12 -> convertedNumber = "C" + convertedNumber;
                case 13 -> convertedNumber = "D" + convertedNumber;
                case 14 -> convertedNumber = "E" + convertedNumber;
                case 15 -> convertedNumber = "F" + convertedNumber;
                default -> convertedNumber = Integer.toString(remainder) + convertedNumber;
            }
            decNumber /= newBase;
        }

        System.out.println("Число в новой системе счисления: " + convertedNumber);
    }

    /**
     * Задача 8: Перевод между произвольными системами счисления.
     *
     *
     */
    private static void anyBaseToAnyBaseConversion(Scanner scanner) {
        System.out.println("\nПеревод между произвольными системами счисления:");
        System.out.print("Введите число в исходной системе счисления: ");
        String inputNumber = scanner.next();
        System.out.print("Введите основание исходной системы счисления: ");
        int oldBase = scanner.nextInt();
        System.out.print("Введите основание новой системы счисления: ");
        int newBase = scanner.nextInt();

        int decimalValue = convertFromAnyBase(inputNumber, oldBase);
        String convertedNumber = convertToAnyBase(decimalValue, newBase);

        System.out.println("Число в новой системе счисления: " + convertedNumber);
    }

    /**
     * Преобразует строку, представляющую число в системе счисления с основанием
     * oldBase, в десятичную систему.
     *
     * 
     */
    private static int convertFromAnyBase(String number, int oldBase) {
        int decimalValue = 0;
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            int value = Character.isDigit(digit) ? digit - '0' : digit - 'A' + 10;
            decimalValue = decimalValue * oldBase + value;
        }
        return decimalValue;
    }

    /**
     * Преобразует десятичное число в систему счисления с основанием newBase.
     *
     * 
     */
    private static String convertToAnyBase(int decimalValue, int newBase) {
        StringBuilder sb = new StringBuilder();
        while (decimalValue > 0) {
            int remainder = decimalValue % newBase;
            char digit = remainder < 10 ? (char) ('0' + remainder) : (char) ('A' + remainder - 10);
            sb.append(digit);
            decimalValue /= newBase;
        }
        return sb.reverse().toString();
    }

    /**
     * Задача 9: Ввести число от 1 до 12. Вывести на консоль название месяца,
     * соответствующего данному числу.
     *
     */
    private static void monthNameByNumber(Scanner scanner) {
        System.out.println("\nНазвание месяца по номеру:");
        System.out.print("Введите номер месяца (от 1 до 12): ");
        int monthNumber = scanner.nextInt();

        switch (monthNumber) {
            case 1 -> System.out.println("Январь");
            case 2 -> System.out.println("Февраль");
            case 3 -> System.out.println("Март");
            case 4 -> System.out.println("Апрель");
            case 5 -> System.out.println("Май");
            case 6 -> System.out.println("Июнь");
            case 7 -> System.out.println("Июль");
            case 8 -> System.out.println("Август");
            case 9 -> System.out.println("Сентябрь");
            case 10 -> System.out.println("Октябрь");
            case 11 -> System.out.println("Ноябрь");
            case 12 -> System.out.println("Декабрь");
            default -> System.out.println("Некорректный номер месяца. Попробуйте еще раз.");
        }
    }
}
