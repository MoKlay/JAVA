package Stage_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Option_C {
  private static int[][] matrix;
  private static final Random random = new Random(); // Создание объекта класса Random

  public static void main(String[] args) {
    clearConsole();
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Введите размерность матрицы n: ");
      int n = scanner.nextInt();
      clearConsole();

      // Создаем матрицу размером n x n
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы

      // 1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений
      // элементов k-го столбца (строки)
      System.out.println("\n1. Упорядочивание строк по возрастанию значений элементов k-го столбца");
      System.err.println("Введите индекс столбца k для сортировки по строкам: ");
      int k = scanner.nextInt();
      sortRowsByColumn(k);
      printMatrix(matrix);

      pause(scanner);

      // 2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо
      // (влево, вверх, вниз)
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n2. Циклический сдвиг матрицы на k позиций вправо");
      System.err.println("Введите индекс позиции для сдвига: ");
      k = scanner.nextInt();
      shiftMatrixRight(k);
      printMatrix(matrix);
      pause(scanner);

      // 3. Найти и вывести наибольшее число возрастающих\убывающих элементов
      // матрицы, идущих подряд
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n3. Наибольшее число возрастающих/убывающих элементов подряд");
      findLongestSequence(true);
      findLongestSequence(false);
      pause(scanner);

      // 4. Найти сумму элементов матрицы, расположенных между первым и вторым
      // положительными элементами каждой строки
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n4. Сумма элементов между первым и вторым положительным элементом каждой строки");
      for (int[] matrix1 : matrix) {
        sumBetweenFirstAndSecondPositiveElements(matrix1);
      }
      pause(scanner);

      // 5. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху
      // вниз
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n5. Матрица чисел от 1 до k");
      System.out.print("Введите значение k: ");
      k = scanner.nextInt();
      printNumbersInMatrix(k, true);
      printNumbersInMatrix(k, false);
      pause(scanner);

      // 6. Округлить все элементы матрицы до целого числа
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n6. Округление всех элементов матрицы до целых чисел");
      roundAllElements(n);
      printMatrix(matrix);
      pause(scanner);

      // 7. Повернуть матрицу на 90, 180 или 270 градусов против часовой стрелки
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n7. Введите градус поворота матрицы: ");
      int angle = scanner.nextInt();
      rotateMatrix90Degrees(angle);
      printMatrix(matrix);
      pause(scanner);

      // 8. Вычислить определитель матрицы
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n8. Определитель матрицы");
      double determinant = calculateDeterminant(matrix);
      System.out.printf("Определитель матрицы равен %.2f\n", determinant);
      pause(scanner);

      // 9. Построить матрицу, вычитая из элементов каждой строки матрицы её
      // среднее арифметическое
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n9. Матрица с вычтенным средним арифметическим каждой строки");
      subtractMeanFromEachRow();
      printMatrix(matrix);
      pause(scanner);

      // 10. Найти максимальный элемент(ы) в матрице и удалить из матрицы все
      // строки и столбцы, его содержащие
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n10. Удаление строк и столбцов с максимальными элементами");

      printMatrix(removeMaxElement(matrix));
      pause(scanner);

      // 11. Уплотнить матрицу, удаляя из неё строки и столбцы, заполненные нулями
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n11. Уплотнение матрицы путём удаления нулевых строк и столбцов");

      printMatrix(compactMatrix(matrix));
      pause(scanner);

      // 12. В матрице найти минимальный элемент и переместить его на место
      // заданного элемента путем перестановки строк и столбцов
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n12. Перемещение минимального элемента на заданное место");
      moveMinElement(1, 1); // Перемещаем минимальный элемент на позицию(1, 1)
      printMatrix(matrix);
      pause(scanner);

      // 13. Преобразовать строки матрицы таким образом, чтобы элементы, равные
      // нулю, располагались после всех остальных
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n13. Преобразование строк, чтобы нули шли последними");
      moveZerosToEnd();
      printMatrix(matrix);
      pause(scanner);

      // 14. Найти количество всех седловых точек матрицы
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n14. Количество седловых точек матрицы");
      System.out.println("Количество седловых точек: " + countSaddlePoints(matrix));
      pause(scanner);

      // 15. Перестроить матрицу, переставляя в ней строки так, чтобы сумма
      // элементов в строках полученной матрицы возрастала
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n15. Перестройка матрицы с увеличением суммы элементов в строках");
      printMatrix(sortMatrixByRowSum(matrix));
      pause(scanner);

      // 16. Найти число локальных минимумов
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n16. Поиск локальных минимумов:" + countLocalMinima());
      pause(scanner);

      // 17. Найти наименьший среди локальных максимумов
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n17. Поиск наименьшего локального максимума");
      System.err.println("Наименьший локальный максимум: " + findSmallestLocalMaximum(matrix));
      pause(scanner);

      // 18. Перестроить заданную матрицу, переставляя в ней столбцы так, чтобы
      // значения их характеристик убывали
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n18. Перестройка матрицы с убыванием характеристик столбцов");
      printMatrix(sortColumnsByCharacteristics(matrix));
      pause(scanner);

      // 19. Добиться того, чтобы максимальный элемент находился в левом верхнем
      // углу, следующий по величине — в позиции (2, 2), и т.д.
      createMatrix(n);

      printMatrix(matrix); // Для проверки вывода исходной матрицы
      System.out.println("\n19. Перестройка главной диагонали по убыванию");
      arrangeMaxOnDeiagonal();
      printMatrix(matrix);

      scanner.close();
    }
  }

  private static void pause(Scanner s) {
    System.out.println("Нажмите Enter для продолжения");
    s.next();
    clearConsole();
  }

  @SuppressWarnings("deprecation")
  private static void clearConsole() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException e) {
    }
  }

  private static void arrangeMaxOnDeiagonal() {
    int n = matrix.length;
    ArrayList<Integer> elements = new ArrayList<>();

    for (int[] row : matrix) {
      for (int element : row) {
        elements.add(element);
      }
    }

    elements.sort(Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      matrix[i][i] = elements.get(i);
    }

    int idx = n;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j) {
          matrix[i][j] = elements.get(idx++);
        }
      }
    }
  }

  private static int[][] sortColumnsByCharacteristics(int[][] matrix) {
    int n = matrix.length;
    Integer[] columnIndex = new Integer[n];
    int[] columnCharacteristics = new int[n];

    for (int j = 0; j < n; j++) {
      columnIndex[j] = j;
      columnCharacteristics[j] = calculateColumnCharacteristics(matrix, j);
    }

    Arrays.sort(columnIndex, (a, b) -> Integer.compare(columnCharacteristics[b], columnCharacteristics[a]));

    int[][] sortedMatrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sortedMatrix[i][j] = matrix[i][columnIndex[j]];
      }
    }
    return sortedMatrix;
  }

  private static int calculateColumnCharacteristics(int[][] matrix, int col) {
    int sum = 0;
    for (int[] row : matrix) {
      sum += Math.abs(row[col]);
    }
    return sum;
  }

  private static Integer findSmallestLocalMaximum(int[][] matrix) {
    int n = matrix.length;
    List<Integer> localMaxima = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isLocalMaximum(matrix, i, j)) {
          localMaxima.add(matrix[i][j]);
        }
      }
    }

    if (!localMaxima.isEmpty()) {
      return localMaxima.stream().min(Integer::compareTo).orElse(null);
    } else {
      return null;
    }
  }

  private static boolean isLocalMaximum(int[][] matrix, int row, int col) {
    int n = matrix.length;
    int currentValue = matrix[row][col];

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0)
          continue;

        int neighborRow = row + i;
        int neighbourCol = col + j;

        if (neighborRow >= 0 && neighborRow < n && neighbourCol >= 0 && neighbourCol < n) {
          if (matrix[neighborRow][neighbourCol] >= currentValue) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static int countLocalMinima() {
    int count = 0;
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isLocalMinimum(i, j)) {
          count++;
        }
      }
    }
    return count;
  }

  private static boolean isLocalMinimum(int row, int col) {
    int n = matrix.length;
    int currentValue = matrix[row][col];

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0)
          continue;

        int neighborRow = row + i;
        int neighborCol = col + j;

        if (neighborRow >= 0 && neighborRow < n && neighborCol >= 0 && neighborCol < n) {
          if (matrix[neighborRow][neighborCol] <= currentValue) {
            return false;
          }

        }
      }
    }
    return true;
  }

  private static int[][] sortMatrixByRowSum(int[][] matrix) {
    int n = matrix.length;
    int[][] sortedMatrix = new int[n][n];

    // Вычисление суммы для каждой строки
    System.arraycopy(matrix, 0, sortedMatrix, 0, n); // Копируем строки в новый массив

    Arrays.sort(sortedMatrix,
        (int[] row1, int[] row2) -> Integer.compare(Arrays.stream(row1).sum(), Arrays.stream(row2).sum()));

    return sortedMatrix;
  }

  private static int countSaddlePoints(int[][] matrix) {
    int count = 0;
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int currentElement = matrix[i][j];
        boolean isMinInRow = true;
        for (int k = 0; k < n; k++) {
          if (matrix[i][k] < currentElement) {
            isMinInRow = false;
            break;
          }
        }

        boolean isMaxInColumn = true;
        for (int k = 0; k < n; k++) {
          if (matrix[k][j] > currentElement) {
            isMaxInColumn = false;
            break;
          }
        }
        if (isMinInRow && isMaxInColumn) {
          count++;
        }
      }
    }

    return count;
  }

  private static void moveZerosToEnd() {
    for (int i = 0; i < matrix.length; i++) {
      int[] row = matrix[i];
      int[] resultRow = new int[row.length];
      int index = 0;

      // Сначала добавляем ненулевые элементы
      for (int value : row) {
        if (value != 0) {
          resultRow[index++] = value;
        }
      }

      // Затем добавляем нули
      while (index < resultRow.length) {
        resultRow[index++] = 0;
      }

      // Копируем измененную строку обратно в матрицу
      matrix[i] = resultRow;
    }
  }

  private static void moveMinElement(int targetRow, int targetCol) {
    int n = matrix.length;
    int minElement = Integer.MAX_VALUE;
    int minRow = -1;
    int minCol = -1;

    // Находим минимальный элемент и его координаты
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] < minElement) {
          minElement = matrix[i][j];
          minRow = i;
          minCol = j;
        }
      }
    }

    // Перемещение минимального элемента на заданную позицию
    // Меняем местами строки
    for (int j = 0; j < n; j++) {
      int temp = matrix[targetRow][j];
      matrix[targetRow][j] = matrix[minRow][j];
      matrix[minRow][j] = temp;
    }

    // Меняем местами столбцы
    for (int i = 0; i < n; i++) {
      int temp = matrix[i][targetCol];
      matrix[i][targetCol] = matrix[i][minCol];
      matrix[i][minCol] = temp;
    }
  }

  private static int[][] compactMatrix(int[][] matrix) {
    int n = matrix.length;

    // Находим строки, заполненные нулями
    List<Integer> zeroRows = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      boolean isZeroRow = true;
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] != 0) {
          isZeroRow = false;
          break;
        }
      }
      if (isZeroRow) {
        zeroRows.add(i);
      }
    }

    List<Integer> zeroCols = new ArrayList<>();
    for (int j = 0; j < n; j++) {
      boolean isZeroCol = true;
      for (int i = 0; i < n; i++) {
        if (matrix[i][j] != 0) {
          isZeroCol = false;
          break;
        }
      }
      if (isZeroCol) {
        zeroCols.add(j);
      }
    }

    int newRows = n - zeroRows.size();
    int newCols = n - zeroCols.size();
    int[][] result = new int[newRows][newCols];

    for (int newRow = 0, oldRow = 0; oldRow < n; oldRow++) {
      if (zeroRows.contains(oldRow))
        continue; // Пропускаем нулевую строку
      for (int newCol = 0, oldCol = 0; oldCol < n; oldCol++) {
        if (zeroCols.contains(oldCol))
          continue; // Пропускаем нулевой столбец
        result[newRow][newCol++] = matrix[oldRow][oldCol];
      }
      newRow++;
    }

    return result;
  }

  private static int[][] removeMaxElement(int[][] matrix) {
    int n = matrix.length;
    int maxElement = Integer.MIN_VALUE;
    int maxRow = -1;
    int maxCol = -1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] > maxElement) {
          maxElement = matrix[i][j];
          maxRow = i;
          maxCol = j;
        }
      }
    }

    int newRows = n - 1;
    int newCols = n - 1;
    int[][] result = new int[newRows][newCols];

    for (int i = 0, newRow = 0; i < n; i++) {
      if (i == maxRow)
        continue;
      for (int j = 0, newCol = 0; j < n; j++) {
        if (j == maxCol)
          continue;
        result[newRow][newCol++] = matrix[i][j];
      }
      newRow++;
    }

    return result;
  }

  private static void subtractMeanFromEachRow() {
    int n = matrix.length;
    double[][] result = new double[n][n];

    for (int i = 0; i < n; i++) {
      double rowMean = calculateMean(matrix[i]);
      for (int j = 0; j < n; j++) {
        result[i][j] = matrix[i][j] - rowMean;
      }
    }

    printMatrix(result);
  }

  private static double calculateDeterminant(int[][] matrix) {
    int n = matrix.length;

    if (n == 1) {
      return matrix[0][0];
    }

    if (n == 2) {
      return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    int determinant = 0;
    for (int j = 0; j < n; j++) {
      determinant += Math.pow(-1, j) * matrix[0][j] * calculateDeterminant(getMinor(0, j));
    }

    return determinant;
  }

  private static void rotateMatrix90Degrees(int angle) {
    int n = matrix.length;
    int[][] rotatedMatrix = new int[n][n];

    switch (angle) {
      case 90 -> {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            rotatedMatrix[n - j - 1][i] = matrix[i][j];
          }
        }
      }
      case 180 -> {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            rotatedMatrix[n - i - 1][n - j - 1] = matrix[i][j];
          }
        }
      }
      case 270 -> {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            rotatedMatrix[j][n - i - 1] = matrix[i][j];
          }
        }
      }
      default -> {
        System.out.println("Некорректный угол поворота.");
        return;
      }
    }

    System.out.println("Матрица после поворота на " + angle + " градусов:");
    printMatrix(rotatedMatrix);
  }

  private static void roundAllElements(int n) {
    float[][] matrixlocal = new float[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrixlocal[i][j] = (float) (random.nextInt(2 * n + 1) - n);
      }
    }
    printMatrix(matrixlocal);

    int[][] matrixAround = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrixAround[i][j] = (int) matrixlocal[i][j];
      }
    }
    printMatrix(matrixAround);

  }

  private static void printNumbersInMatrix(int k, boolean in) {
    int n = (int) Math.ceil(Math.sqrt(k));
    int[][] matrixlocal = new int[n][n];

    int number = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (number <= k && in == true) {
          matrixlocal[i][j] = number++;
        } else if (number <= k && in == false) {
          matrixlocal[j][i] = number++;
        } else {
          if (in == true) {
            matrixlocal[i][j] = 0;
          } else {
            matrixlocal[j][i] = 0;
          }
        }
      }
    }

    printMatrix(matrixlocal);
  }

  private static int sumBetweenFirstAndSecondPositiveElements(int[] row) {
    int firstPositiveIndex = -1;
    int secondPositiveIndex = -1;

    // Поиск первого и второго положительных элементов
    for (int j = 0; j < row.length; j++) {
      if (row[j] > 0) {
        if (firstPositiveIndex == -1) {
          firstPositiveIndex = j;
        } else {
          secondPositiveIndex = j;
          break;
        }
      }
    }

    if (firstPositiveIndex != -1 && secondPositiveIndex != -1) {
      int sum = 0;
      for (int j = firstPositiveIndex + 1; j < secondPositiveIndex; j++) {
        sum += row[j];
      }
      return sum;
    }

    return 0;
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

  private static void printMatrix(float[][] matrix) {
    for (float[] matrix1 : matrix) {
      for (float j : matrix1) {
        System.out.printf("%3.2f ", j);
      }
      System.out.println();
    }
    System.out.println();

  }

  private static void printMatrix(double[][] matrix) {
    for (double[] matrix1 : matrix) {
      for (double j : matrix1) {
        System.out.printf("%3.2f ", j);
      }
      System.out.println();
    }
    System.out.println();

  }

  private static void sortRowsByColumn(int k) {
    if (k > matrix.length || k <= 0) {
      throw new IllegalArgumentException("Неверный индекс столбца");
    }

    Arrays.sort(matrix, (a, b) -> Integer.compare(a[k - 1], b[k - 1]));
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

  private static void findLongestSequence(boolean increasing) {
    int n = matrix.length;
    int maxLength = 0;

    // Проверка всех направлений (вправо, вниз, вправо-вниз, влево-вниз)
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        maxLength = Math.max(maxLength, countSequence(i, j, 1, 0, increasing)); // Вправо
        maxLength = Math.max(maxLength, countSequence(i, j, 0, 1, increasing)); // Вниз
        maxLength = Math.max(maxLength, countSequence(i, j, 1, 1, increasing)); // Вправо-вниз (диагональ)
        maxLength = Math.max(maxLength, countSequence(i, j, 1, -1, increasing)); // Влево-вниз (диагональ)
      }
    }

    if (increasing == false) {
      System.err.println("Максимальная длина убывающей последовательности: " + maxLength);
    } else {
      System.err.println("Максимальная длина возрастающей последовательности: " + maxLength);
    }
  }

  private static int countSequence(int row, int col, int rowDir, int colDir, boolean increasing) {
    int n = matrix.length;
    int length = 1;

    while (row + rowDir >= 0 && row + rowDir < n && col + colDir >= 0 && col + colDir < n) {
      if ((increasing && matrix[row + rowDir][col + colDir] > matrix[row][col])
          || (!increasing && matrix[row + rowDir][col + colDir] < matrix[row][col])) {
        length++;
        row += rowDir;
        col += colDir;
      } else {
        break;
      }
    }

    return length;
  }

  private static int[][] getMinor(int row, int col) {
    int n = matrix.length;
    int[][] minor = new int[n - 1][n - 1];

    for (int i = 0, minorRow = 0; i < n; i++) {
      if (i == row)
        continue; // пропускаем строку
      for (int j = 0, minorCol = 0; j < n; j++) {
        if (j == col)
          continue; // пропускаем столбец
        minor[minorRow][minorCol++] = matrix[i][j];
      }
      minorRow++;
    }

    return minor;
  }

  private static double calculateMean(int[] row) {
    double sum = 0;
    for (int value : row) {
      sum += value;
    }
    return sum / row.length;
  }
}
