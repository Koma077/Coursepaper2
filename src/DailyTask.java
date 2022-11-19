import java.time.LocalDate;
import java.time.LocalDateTime;


public class DailyTask extends Task {

    public DailyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    public LocalDateTime nextDate(LocalDate date) {
        while (getDateTime().toLocalDate().isBefore(date)) {
            setDateTime(getDateTime().plusDays(1));
        }
        return getDateTime();
    }

}
