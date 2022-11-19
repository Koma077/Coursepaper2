import jdk.jshell.execution.LoaderDelegate;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.time.format.DateTimeFormatter.ofPattern;

public class TaskService {

    private Map<Integer, Task> taskMap = new HashMap<>();
    private Collection<Task> removeTask;

    //    public Task findId(int id){
//        return taskMap.get(id);
//    }
    public void add(Task task) {
        taskMap.put(task.getId(), task);

    }

    public void remove(int id) {
        taskMap.remove(id);
    }
//    public Map<Integer, Task> getTaskMap(){
//        return taskMap;
//    }

    Collection< Task> getDate(LocalDate inputDate){
        List<Task> resultList = new ArrayList<>();
        for(Map.Entry<Integer, Task> integerTaskEntry : taskMap.entrySet()){
            Task task = integerTaskEntry.getValue();
            if(task.getNextDate(inputDate)){
                resultList.add(task);
            }
        }
        return resultList;
    }
}









