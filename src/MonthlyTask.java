import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{

    public MonthlyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    public LocalDateTime nextDate(LocalDate date) {
        while (getDateTime().toLocalDate().isBefore(date)) {
            setDateTime(getDateTime().plusMonths(1));
        }
        return getDateTime();
    }

}
