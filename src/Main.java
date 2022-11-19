

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        System.out.println("Выберите пункт меню : ");
        if(scanner.hasNextInt()){
            int menu = scanner.nextInt();
            switch (menu){
                case 1:
                    addTask(taskService, scanner);
                    break;
                case 2:
                    getTask(taskService, scanner);
                    break;
                case 3:
                    removeTask(taskService, scanner);
                    break;
            }
        }else {
            scanner.next();
            System.out.println("Выберите пункт из списска!");
        }
    }
    public  static  void printMenu(){
        System.out.println("\"1\" Добавить задачу : ");
        System.out.println("\"2\" Показать задачу : ");
        System.out.println("\"3\" Удалить задачу : ");
        System.out.println("\"4\" Изменить задачу : ");
        System.out.println("\"5\" Показать все задачи : ");
        System.out.println("\"6\" Показать задачи на дату : ");
        System.out.println("\"7\" Показать удаленные задачи : ");
        System.out.println("\"0\" Вернуться в начало списка : ");
    }

    private static void addTask(TaskService taskService, Scanner scanner) {
        System.out.println("Введите заголовок задачи : ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.println("Введите описание задачи : ");
        String description = scanner.nextLine();
        System.out.println("Введите тип задачи 'Личный(1)' или 'Рабочий(2)'");
        int type = scanner.nextInt();
        Type choice = type == 1? Type.PERSONAL: Type.WORKER;
        System.out.println("Введите дату и время в формате yyyy-mm-dd Hh:Mm : ");
        String date = scanner.nextLine();
        LocalDate dateTask = LocalDate.parse(scanner.next());
        LocalTime timeTask = LocalTime.parse(scanner.next());
        LocalDateTime startTime = LocalDateTime.of(dateTask, timeTask);
        System.out.println("Введите повторяемость задачи : ");
        System.out.println("0-Не повторяется");
        System.out.println("1-Дневная");
        System.out.println("2-Недельная");
        System.out.println("3-Месячная");
        System.out.println("4-Годовая");
        int typeTask = scanner.nextInt();
        switch (typeTask){
            case 0:
                taskService.add(new Task(name,description, choice, startTime));
                break;
            case 1:
                taskService.add(new DailyTask(name,description, choice, startTime));
                break;
            case 2:
                taskService.add(new WeeklyTask(name,description, choice, startTime));
                break;
            case 3:
                taskService.add(new MonthlyTask(name,description, choice, startTime));
                break;
            case 4:
                taskService.add(new YearlyTask(name,description, choice, startTime));
                break;
            default:
                throw new RuntimeException("Выберите правильный тип задачи!");

        }
    }
    public static void removeTask(TaskService taskService, Scanner scanner){
        System.out.println("Веедите id задачи, который необходимо удалить : ");
        int id = scanner.nextInt();
        taskService.remove(id);


    }
    public static void getTask(TaskService taskService, Scanner scanner){
        System.out.println("Введите дату и время в формате yyyy-mm-dd Hh:Mm : ");
        String date = scanner.nextLine();
        LocalDate dateTask = LocalDate.parse(scanner.next());
        LocalTime timeTask = LocalTime.parse(scanner.next());
        LocalDateTime startTime = LocalDateTime.of(dateTask, timeTask);
        Collection<Task> allTask = taskService.getDate(dateTask);
        System.out.println("Список задач на этот день : ");
        for(Task task : allTask){
            System.out.println(task);
        }

    }
}
