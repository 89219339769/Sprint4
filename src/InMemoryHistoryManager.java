import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    public static Collection<Task>tasks = new ArrayList<>();



    //добавляем задачу в список просмотров
    @Override
    public void addTask(Task task) {

        tasks.add(task);
        if(tasks.size() > 10){
            tasks.remove(0);
        }
    }

    @Override
    public Collection<Task>  getHistory() {
        return tasks;
    }

    //возвращаем список просмотров



}
