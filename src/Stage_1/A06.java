package Stage_1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class A06 {
    public static void main(String[] args) {
        //Вывести фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
        System.out.println("Разработчик: Цыренов Чингис, группа Б762-1");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("Дата и время получения заданий: 07.09.2024 15:20:00");
        System.out.println("Дата и время сдачи заданий:     " + now.format(formatter));
        
    }
}
