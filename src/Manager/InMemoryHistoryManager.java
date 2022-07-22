package Manager;

import Tasks.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    public static List<Task>tasks = new ArrayList<>();
    static final int MAX_VALUE = 10;


    //добавляем задачу в список просмотров
    @Override
    public void addTask(Task task) {

        tasks.add(task);


    }

    @Override
    public List<Task> getHistory() {
        return tasks;
    }

    //возвращаем список просмотров



}
