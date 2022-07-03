import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    private int id = 0;
    private HashMap<Integer, Task> taskMap = new HashMap<>();
    private HashMap<Integer, Epic> epicMap = new HashMap<>();
    private HashMap<Integer, SubTask> subTaskMap = new HashMap<>();

   // берем список задач сохраненных в памяти
    HistoryManager historyManager = new InMemoryHistoryManager();


    // 1 методы для создания задачи всех типов
    @Override
    public void addTask(Task task) {
        task.setId(id++);
        taskMap.put(task.getId(), task);
    }
    @Override
    public void addEpic(Epic task) {
        task.setId(id++);
        epicMap.put(task.getId(), task);
    }
    @Override
    public void addSubTask(SubTask subTask) {
        Integer epicIdOfSubTask = subTask.getEpicId();
        if (epicMap.containsKey(epicIdOfSubTask)) {
            int subTaskId = this.id++;
            subTask.setId(subTaskId);
            subTaskMap.put(subTaskId, subTask);
            Epic epic = epicMap.get(epicIdOfSubTask);
            epic.addSubTask(subTask);

        } else {
            System.out.println(" Эпика с номером " + subTask.getEpicId() + " не сущствует");
        }
    }

    //2 методы для получение списка  задач типов
    @Override
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
    @Override
    public void printOllSubTasks() {
        for (Integer taskId : subTaskMap.keySet()) {
            Task task = subTaskMap.get(taskId);
            SubTask subtask = subTaskMap.get(taskId);
            System.out.println(" Подзадача эпика " + subtask.getEpicId() + task);
        }
    }

    //3 обновили задачу статус задачи поменялся на DONE
    @Override
    public void updateStatusOfTask(Task task) {
        Integer epicIdOfTask = task.getId();
        if (taskMap.containsKey(epicIdOfTask)) {
            taskMap.put(task.getId(), task);
            task.changeStatusOnDone();
        }
    }

    //4 метод управляет статусом эпика в зависимости от подзадач
    @Override
    public void updateStatusOfEpic(int epicId) {
        Epic epic = epicMap.get(epicId);
        ArrayList<SubTask> subTasksOfEpic = epic.getSubTasks();
        if ((subTasksOfEpic.isEmpty())) {  // true - таблица пустая
            epic.setStatus(TaskStatus.NEW);
        } else {
            int a = 0;
            int b = 0;

            for (SubTask x : subTasksOfEpic) {
                TaskStatus y = x.getStatus();
                if (y.equals(TaskStatus.NEW)) {
                    a += 1;
                } else if (y.equals(TaskStatus.DONE)) {
                    b += 1;
                }
            }
            if ((a != 0) && (a == subTasksOfEpic.size())) {
                epic.setStatus(TaskStatus.NEW);
            } else if ((b != 0) && (b == subTasksOfEpic.size())) {
                epic.setStatus(TaskStatus.DONE);
            } else {
                epic.setStatus(TaskStatus.IN_PROGRESS);
            }
        }
    }


    //5 Обнвление  задач всех типов
    @Override
    public void updateTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void updateSubTask(SubTask subTask) {
        subTaskMap.put(subTask.getId(), subTask);
    }

    public void apdateEpic(Epic epic) {
        epicMap.put(epic.getId(), epic);
    }

    // 6 Удаление всех задач.
    public void deleteTasks() {
        taskMap.clear();
    }

    public void deleteSubTasks() {
        for (Epic epic : epicMap.values()) {
            epic.clearSubTask();
        }
        subTaskMap.clear();
    }




    //7 методы получения всех типов задач по идентификатору.
    @Override
    public void getTask(int id) {  // Получение задачи по ID
        if (taskMap.isEmpty()) {
            System.out.println("В трекере задач нет задач");
            return;
        }
        if (!taskMap.containsKey(id)) {
            System.out.println("Задача с данным ID нет");
            return;
        }
        Task task = taskMap.get(id);
            System.out.println(task);
            historyManager.addTask(task);

    }




    @Override
    public SubTask getSubTask(int id) {
        return subTaskMap.get(id);
    }
    @Override
    public Epic getEpic(int id) {
        return epicMap.get(id);
    }

    //Удаление  задач всех типов по индификатору
    @Override
    public void deleteTask(int id) {   //6. Удаление по идентификатору.
        taskMap.remove(id);
    }
    @Override
    public void deleteEpic(int id) {
        Epic epic = epicMap.get(id);
        ArrayList<SubTask> subTasksOfEpic = epic.getSubTasks();
        subTasksOfEpic.clear();
        epicMap.remove(id);
    }
    @Override
    public void deleteSubTask(int id) {
        SubTask subTasksOfEpic = subTaskMap.get(id);
        subTaskMap.remove(id);
        int epicIdOfSubTask = subTasksOfEpic.getEpicId();
        Epic epic = epicMap.get(epicIdOfSubTask);
        epic.delSubTask(subTasksOfEpic);
        updateStatusOfEpic(epicIdOfSubTask);

    }
}
