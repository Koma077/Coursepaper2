import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {


    public YearlyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    public LocalDateTime nextDate(LocalDate date) {
        while (getDateTime().toLocalDate().isBefore(date)) {
            setDateTime(getDateTime().plusYears(1));
        }
        return getDateTime();
    }

}
