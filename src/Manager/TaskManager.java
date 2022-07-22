package Manager;

import Tasks.Epic;
import Tasks.SubTask;
import Tasks.Task;

import java.util.HashMap;
import java.util.Map;

public interface TaskManager {

    Map<Integer, Task> taskMap = new HashMap<>();
    Map<Integer, Epic> epicMap = new HashMap<>();
    Map<Integer, SubTask> subTaskMap = new HashMap<>();


    public void addTask(Task task);

    public void addEpic(Epic task);

    public void addSubTask(SubTask subTask);

    //2 методы для получение списка  задач типов
    public void printOllTasks();

    public void printOllEpics();

    public void printOllSubTasks();

    //3 обновили задачу статус задачи поменялся на DONE
    public void updateStatusOfTask(Task task);

    //4 метод управляет статусом эпика в зависимости от подзадач
    public void updateStatusOfEpic(int epicId);

    //5 Обнвление  задач всех типов
    public void updateTask(Task task);

    public void updateSubTask(SubTask subTask);

    public void apdateEpic(Epic epic);

    // 6 Удаление всех задач.
    public void deleteTasks();

    public void deleteSubTasks();


    //7 методы получения всех типов задач по идентификатору.
    public void getTask(int id);

    public void getSubTask(int id);

    public void getEpic(int id);

    //Удаление  задач всех типов по индификатору
    public void deleteTask(int id);

    public void deleteEpic(int id);

    public void deleteSubTask(int id);
}
