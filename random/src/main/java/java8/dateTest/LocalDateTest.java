package java8.dateTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jesse.hu
 * @date 2022/2/24 17:37
 */
public class LocalDateTest {
    public static void main(String[] args) {
        // yyyy-MM-dd
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // HH:mm:ss
        LocalTime time = LocalTime.now().withNano(0);
        System.out.println(time);

        //format yyyy-MM-dd HH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println(format);
    }
}
