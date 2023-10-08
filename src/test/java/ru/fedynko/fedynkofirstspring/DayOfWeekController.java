package ru.fedynko.fedynkofirstspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayOfWeekController {

    @GetMapping("/day/{dayOfWeek}")
    public String getDayInRussian(@PathVariable String dayOfWeek) {
        try {
            DayOfWeek inputDay = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
            return inputDay.getRussianName();
        } catch (IllegalArgumentException e) {
            return "Неверно указан день недели";
        }
    }
}

