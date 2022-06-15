
import java.util.ArrayList;
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


    //обновили задачу статус задачи поменялся на DONE
    public void changeStatusOfTask(Task task) {
        Integer epicIdOfTask = task.getId();
        if (taskMap.containsKey(epicIdOfTask)); {
            taskMap.put(task.getId(), task);
            task.changeStatusOnDone();
        }
    }

    //метод управляет статусом эпика в зависимости от подзадач
    public void changeStatusOfEpic(int epicId) {    // 4.2 Управление статусами
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








    //методы получения всех типов задач по идентификатору.
    public Task getTask(int id) {
        return taskMap.get(id);
    }

    public SubTask getSubTask(int id) {
        return subTaskMap.get(id);
    }

    public Epic getEpic(int id) {
        return epicMap.get(id);
    }




}
