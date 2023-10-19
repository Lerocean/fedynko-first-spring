package ru.fedynko.fedynkofirstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class WeekdayApp {

    public static void main(String[] args) {
        SpringApplication.run(WeekdayApp.class, args);
    }

    @GetMapping("/")
    public String getWeekday(@RequestParam(required = false) String day) {
        String inputDay;
        if (day == null) {
            System.out.print("Введите название дня недели на английском: ");
            Scanner scanner = new Scanner(System.in);
            inputDay = scanner.nextLine();
        } else {
            inputDay = day;
        }

        String russianWeekday;
        try {
            DayOfWeek weekday = DayOfWeek.valueOf(inputDay.toUpperCase());
            Locale russianLocale = new Locale("ru");
            russianWeekday = weekday.getDisplayName(TextStyle.FULL, russianLocale);
        } catch (IllegalArgumentException e) {
            russianWeekday = "Неверный день недели";
        }
        return russianWeekday;
    }
}
