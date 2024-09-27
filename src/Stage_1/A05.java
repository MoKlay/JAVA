package Stage_1;
public class A05 {
    public static void main(String[] args) {
        //Ввести целые числа как аргументы командной строки, подсчитать их суммы и произведения. Вывести результат на консоль.
        if (args.length != 0) {
            int sum = 0;
            int com = 1;
            for (String arg : args) {
                int num = Integer.parseInt(arg);
                sum += num;
                com *= num;
            }
            System.out.println("Сумма аргументов равна " + sum);
            System.out.println("Произведение аргументов равна " + com);
        } 
    }
}
