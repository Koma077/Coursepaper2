import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task implements Repeatable {
    private int id;
    private String title;
    private String description;
    private Type type;
    private LocalDateTime dateTime;
    private static int generateId;
    private boolean isDelete;

    public boolean isDelete(LocalDateTime inputDate) {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Task(String title, String description, Type type, LocalDateTime dateTime) {
        this.id = generateId++;
        this.title = title;
        this.description = description;
        this.type = type;
        this.dateTime = dateTime;


    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean getNextDate(LocalDate inputDate) {
        return inputDate.isEqual(getDateTime().toLocalDate());
    }
}
