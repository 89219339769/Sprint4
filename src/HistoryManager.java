import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface HistoryManager {


    public void addTask(Task task);

   public Collection<Task>  getHistory();


}
