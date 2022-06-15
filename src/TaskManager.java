
import java.util.HashMap;

public class TaskManager {
int id =0;
    private HashMap<Integer, Task> taskMap = new HashMap<>();
    private HashMap<Integer, Epic> epicMap = new HashMap<>();
    private HashMap<Integer, SubTask> subTaskMap = new HashMap<>();

    //методы для создания задачи всех типов
    public void addTask(Task task) {
        task.setId(id++);
        taskMap.put(task.getId(), task);
    }
    public void addEpic(Epic task) {
        task.setId(id++);
        epicMap.put(task.getId(), task);
    }

    public void addSubTask(SubTask subTask) {
        Integer epicIdOfSubTask = subTask.getEpicId();
        if (epicMap.containsKey(epicIdOfSubTask)) {
            int subTaskId = this.id++;
            subTask.setId(subTaskId);
            subTaskMap.put(subTaskId, subTask);
            Epic epic = epicMap.get(epicIdOfSubTask);
            epic.addSubTask(subTask);

        }else{
            System.out.println("Такого эпика не сучествует");
        }
    }

    //методы для получение списка  задач типов
    public void printOllTasks() {
        for (Integer taskId : taskMap.keySet()) {
            Task task = taskMap.get(taskId);
            System.out.println(" Задача " + task);
        }
    }

    public void printOllEpics() {
        for (Integer taskId : epicMap.keySet()) {
            Task task = epicMap.get(taskId);
            System.out.println(" Эпик " + task);
        }
    }

    public void printOllSubTasks() {
        for (Integer taskId : subTaskMap.keySet()) {
            Task task = subTaskMap.get(taskId);
            SubTask subtask = subTaskMap.get(taskId);
            System.out.println(" Подзадача эпика " + subtask.getEpicId() + task);
        }
    }

    public void changeStatusOfTask(Task task) {
        if (taskMap.containsKey(Task.getId()) {
            taskMap.put(Task.getTaskId(), task);
            task.changeStatusOnDone();
        }
    }


}
