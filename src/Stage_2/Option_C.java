package Stage_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Option_C {
  private static int[][] matrix;
  private static Random random = new Random();

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
      k = scanner.nextInt();
      shiftMatrixRight(k);
      printMatrix(matrix);

      // 3. Найти и вывести наибольшее число возрастающих\убывающих элементов
      // матрицы, идущих подряд
      System.out.println("\nНаибольшее число возрастающих/убывающих элементов подряд: " + findLongestSequence());

      // 4. Найти сумму элементов матрицы, расположенных между первым и вторым
      // положительными элементами каждой строки
      System.out.println("\nСумма элементов между первым и вторым положительным элементом каждой строки");
      sumBetweenFirstAndSecondPositiveElements();

      // 5. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
      System.out.println("\nМатрица чисел от 1 до k");
      System.out.println("Введите k: ");
      k = scanner.nextInt();
      printNumbersInMatrix(n, k);

      // // 6. Округлить все элементы матрицы до целого числа
      // System.out.println("\nОкругление всех элементов матрицы до целых чисел");
      // roundAllElements();

      // 7. Повернуть матрицу на 90 градусов против часовой стрелки
      System.out.println("\nПоворот матрицы на 90 градусов против часовой стрелки");
      rotateMatrix90Degrees();

      // 8. Вычислить определитель матрицы
      System.out.println("\nОпределитель матрицы");
      if (n == 2 || n == 3) {
        double determinant = calculateDeterminant();
        System.out.printf("Определитель матрицы равен %.2f\n", determinant);
      } else {
        System.out.println("Вычисление определителя возможно только для матриц 2x2 или 3x3.");
      }

      // 9. Построить матрицу, вычитая из элементов каждой строки матрицы её среднее
      // арифметическое
      System.out.println("\nМатрица с вычтенным средним арифметическим каждой строки");
      subtractMeanFromEachRow();

      // 10. Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и
      // столбцы, его содержащие
      System.out.println("\nУдаление строк и столбцов с максимальными элементами");
      removeMaxElementRowsColumns(matrix);
      printMatrix(matrix);

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
        matrix[i][j] = random.nextInt();
      }
    }
  }

  private static void printMatrix(int[][] matrixlocal) {
    for (int[] matrix1 : matrixlocal) {
      for (int j : matrix1) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void sortRowsByColumn(int k) {
    if (k >= matrix.length || k < 0) {
      throw new IllegalArgumentException("Неверный индекс столбца");
    }

    Arrays.sort(matrix, (a, b) -> Float.compare(a[k], b[k]));
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

  public static int findLongestSequence() {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      System.out.println("Пустая матрица.");
      return 0;
    }

    int maxLen = 0;

    for (int[] row : matrix) {
      maxLen = Math.max(maxLen, findLongestSequenceInArray(row));
    }

    for (int col = 0; col < matrix[0].length; col++) {
      int[] column = new int[matrix.length];
      for (int row = 0; row < matrix.length; row++) {
        column[row] = matrix[row][col];
      }
      maxLen = Math.max(maxLen, findLongestSequenceInArray(column));
    }

    return maxLen;
  }

  private static int findLongestSequenceInArray(int[] arr) {
    if (arr.length == 0)
      return 0;

    int maxLen = 1;
    int currentLen = 1;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[i - 1] || arr[i] < arr[i - 1]) {
        currentLen++;
      } else {
        maxLen = Math.max(maxLen, currentLen);
        currentLen = 1;
      }
    }
    maxLen = Math.max(maxLen, currentLen);
    return maxLen;
  }

  private static void sumBetweenFirstAndSecondPositiveElements() {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    for (int i = 0; i < matrix.length; i++) {
      int firstPositiveIndex = -1;
      int secondPositiveIndex = -1;
      int sum = 0;

      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] > 0) {
          if (firstPositiveIndex == -1) {
            firstPositiveIndex = j;
          } else {
            secondPositiveIndex = j;
            break;
          }
        }
      }

      if (firstPositiveIndex != -1 && secondPositiveIndex != -1) {
        for (int k = firstPositiveIndex + 1; k < secondPositiveIndex; k++) {
          sum += matrix[i][k];
        }
        System.out.println("Сумма строки " + (i + 1) + ": " + sum);
      } else {
        System.out.println("Строка " + (i + 1) + ": Не найдены положительные числа");
      }
    }
  }

  private static void printNumbersInMatrix(int n, int k) {
    if (n <= 0 || k <= 0) {
      return;
    }

    int[][] matrix = new int[n][n];
    int count = 1;
    int maxElements = n * n;

    if (k < maxElements) {
      maxElements = k;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (count <= maxElements) {
          matrix[i][j] = count;
          count++;
        } else {
          matrix[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%4d ", matrix[i][j]); // Format for better spacing
      }
      System.out.println();
    }
  }

  private static void roundAllElements(float[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        matrix[i][j] = (int) matrix[i][j];
      }
      System.out.println();
    }
  }

  public static void rotateMatrix90Degrees() {
    if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
      return;
    }

    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[j][n - 1 - i] = matrix[i][j];
      }
    }

    printMatrix(matrix);
  }

  public static double calculateDeterminant() {
    int n = matrix.length;
    if (n == 0)
      return 0;

    if (n == 1)
      return matrix[0][0];
    if (n == 2) {
      return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    } else if (n == 3) {
      return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
          matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
          matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    } else {
      throw new IllegalArgumentException("Поддерживается матрицами 2 на 2 или 3 на 3");
    }
  }

  public static void subtractMeanFromEachRow() {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    double[][] resultMatrix = new double[rows][cols]; // Use double to handle potential fractions

    for (int i = 0; i < rows; i++) {
      double sum = 0;
      for (int j = 0; j < cols; j++) {
        sum += matrix[i][j];
      }
      double mean = sum / cols;

      for (int j = 0; j < cols; j++) {
        resultMatrix[i][j] = matrix[i][j] - mean;
      }
    }

    for (int i = 0; i < resultMatrix.length; i++) {
      for (int j = 0; j < resultMatrix.length; j++) {
        System.out.print(resultMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void removeMaxElementRowsColumns(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int maxVal = Integer.MIN_VALUE;
    List<Integer> maxRows = new ArrayList<>();
    List<Integer> maxCols = new ArrayList<>();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] > maxVal) {
          maxVal = matrix[i][j];
          maxRows.clear();
          maxCols.clear();
          maxRows.add(i);
          maxCols.add(j);
        } else if (matrix[i][j] == maxVal) {
          maxRows.add(i);
          maxCols.add(j);
        }
      }
    }

    int newRows = rows - maxRows.size();
    int newCols = cols - maxCols.size();
    int[][] newMatrix = new int[newRows][newCols];

    int newRowIdx = 0;
    for (int i = 0; i < rows; i++) {
      if (!maxRows.contains(i)) {
        int newColIdx = 0;
        for (int j = 0; j < cols; j++) {
          if (!maxCols.contains(j)) {
            newMatrix[newRowIdx][newColIdx] = matrix[i][j];
            newColIdx++;
          }
        }
        newRowIdx++;
      }
    }

    System.arraycopy(newMatrix, 0, matrix, 0, newMatrix.length);
  }
}
