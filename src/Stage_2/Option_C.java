package Stage_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Option_C {
  private static int[][] matrix;
  private static Random random;

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Введите размерность матрицы n: ");
      int n = scanner.nextInt();

      // Создаем матрицу размером n x n
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы

      // 1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений
      // элементов k-го столбца (строки)
      System.out.println("\nУпорядочивание строк по возрастанию значений элементов k-го столбца");
      System.err.println("Введите индекс столбца k для сортировки по строкам: ");
      int k = scanner.nextInt();
      sortRowsByColumn(k);
      printMatrix(matrix);

      // 2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо
      // (влево, вверх, вниз)
      System.out.println("\nЦиклический сдвиг матрицы на k позиций вправо");
      System.err.println("Введите индекс позиции для сдвига: ");
      shiftMatrixRight(k);
      printMatrix(matrix, "Матрица после сдвига вправо:");

      // // 3. Найти и вывести наибольшее число возрастающих\убывающих элементов
      // // матрицы, идущих подряд
      // System.out.println("\nНаибольшее число возрастающих/убывающих элементов
      // подряд");
      // findLongestSequence(matrix);

      // // 4. Найти сумму элементов матрицы, расположенных между первым и вторым
      // // положительными элементами каждой строки
      // System.out.println("\nСумма элементов между первым и вторым положительным
      // элементом каждой строки");
      // sumBetweenFirstAndSecondPositiveElements(matrix);

      // // 5. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху
      // вниз
      // System.out.println("\nМатрица чисел от 1 до k");
      // printNumbersInMatrix(n, k);

      // // 6. Округлить все элементы матрицы до целого числа
      // System.out.println("\nОкругление всех элементов матрицы до целых чисел");
      // roundAllElements(matrix);
      // printMatrix(matrix, "Матрица после округления:");

      // // 7. Повернуть матрицу на 90, 180 или 270 градусов против часовой стрелки
      // System.out.println("\nПоворот матрицы на 90 градусов против часовой
      // стрелки");
      // rotateMatrix90Degrees(matrix);
      // printMatrix(matrix, "Матрица после поворота на 90 градусов:");

      // // 8. Вычислить определитель матрицы
      // System.out.println("\nОпределитель матрицы");
      // if (n == 2 || n == 3) {
      // double determinant = calculateDeterminant(matrix);
      // System.out.printf("Определитель матрицы равен %.2f\n", determinant);
      // } else {
      // System.out.println("Вычисление определителя возможно только для матриц 2x2
      // или 3x3.");
      // }

      // // 9. Построить матрицу, вычитая из элементов каждой строки матрицы её
      // среднее арифметическое
      // System.out.println("\nМатрица с вычтенным средним арифметическим каждой
      // строки");
      // subtractMeanFromEachRow(matrix);
      // printMatrix(matrix, "Матрица после вычитания среднего арифметического:");

      // // 10. Найти максимальный элемент(ы) в матрице и удалить из матрицы все
      // строки и столбцы, его содержащие
      // System.out.println("\nУдаление строк и столбцов с максимальными элементами");
      // removeMaxElementRowsColumns(matrix);
      // printMatrix(matrix, "Матрица после удаления строк и столбцов с максимальными
      // элементами:");

      // // 11. Уплотнить матрицу, удаляя из неё строки и столбцы, заполненные нулями
      // System.out.println("\nУплотнение матрицы путём удаления нулевых строк и
      // столбцов");
      // compressMatrix(matrix);
      // printMatrix(matrix, "Уплотнённая матрица:");

      // // 12. В матрице найти минимальный элемент и переместить его на место
      // заданного элемента путем перестановки строк и столбцов
      // System.out.println("\nПеремещение минимального элемента на заданное место");
      // moveMinToPosition(matrix, 1, 1); // Перемещаем минимальный элемент на позицию
      // (1, 1)
      // printMatrix(matrix, "Матрица после перемещения минимального элемента:");

      // // 13. Преобразовать строки матрицы таким образом, чтобы элементы, равные
      // нулю, располагались после всех остальных
      // System.out.println("\nПреобразование строк, чтобы нули шли последними");
      // reorderRowsWithZerosLast(matrix);
      // printMatrix(matrix, "Матрица после преобразования строк:");

      // // 14. Найти количество всех седловых точек матрицы
      // System.out.println("\nКоличество седловых точек матрицы");
      // countSaddlePoints(matrix);

      // // 15. Перестроить матрицу, переставляя в ней строки так, чтобы сумма
      // элементов в строках полученной матрицы возрастала
      // System.out.println("\nПерестройка матрицы с увеличением суммы элементов в
      // строках");
      // rearrangeRowsBySum(matrix);
      // printMatrix(matrix, "Матрица после перестройки строк:");

      // // 16. Найти число локальных минимумов
      // System.out.println("\nПоиск локальных минимумов");
      // findLocalMinima(matrix);

      // // 17. Найти наименьший среди локальных максимумов
      // System.out.println("\nПоиск наименьшего локального максимума");
      // findSmallestLocalMaximum(matrix);

      // // 18. Перестроить заданную матрицу, переставляя в ней столбцы так, чтобы
      // значения их характеристик убывали
      // System.out.println("\nПерестройка матрицы с убыванием характеристик
      // столбцов");
      // rearrangeColumnsByCharacteristic(matrix);
      // printMatrix(matrix, "Матрица после перестройки столбцов:");

      // // 19. Добиться того, чтобы максимальный элемент находился в левом верхнем
      // углу, следующий по величине — в позиции (2, 2), и т.д.
      // System.out.println("\nПерестройка главной диагонали по убыванию");
      // rearrangeDiagonal(matrix);
      // printMatrix(matrix, "Матрица после перестройки главной диагонали:");

      scanner.close();
    }
  }

  private static void createMatrix(int n) {
    matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = random.nextInt(2 * n + 1) - n;
      }
    }
  }

  private static void printMatrix(int[][] matrix) {
    for (int[] matrix1 : matrix) {
      for (int j : matrix1) {
        System.out.printf("%3d ", j);
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void sortRowsByColumn(int k) {
    if (k >= matrix.length || k < 0) {
      throw new IllegalArgumentException("Неверный индекс столбца");
    }

    Arrays.sort(matrix, (a, b) -> Integer.compare(a[k], b[k]));
  }

  private static void shiftMatrixRight(int k) {
    int n = matrix.length; // Количество строк

    int[][] shiftedMatrix = new int[n][n]; // Создаем новую матрицу того же размера

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int newJ = (j + k) % n; // Вычисляем новое положение элемента в строке
        shiftedMatrix[i][newJ] = matrix[i][j];
      }
    }

    matrix = shiftedMatrix; // Сохраняем новую матрицу
  }
}
