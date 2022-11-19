import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    public LocalDateTime nextDate(LocalDate date) {
        while (getDateTime().toLocalDate().isBefore(date)) {
            setDateTime(getDateTime().plusWeeks(1));
        }
        return getDateTime();
    }

}
