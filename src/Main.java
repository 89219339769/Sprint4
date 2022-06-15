public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        // Создаем задачи всех типов
        Task task0 = new Task("Задача","просто задача", TaskStatus.NEW);
        Task task1 = new Task("Задача1","просто задача1", TaskStatus.NEW);
        Task task2 = new Task("Задача2","просто задача2", TaskStatus.NEW);

        Epic task3 = new Epic ("Эпик", " Подготовка к празднику", TaskStatus.NEW);
        Epic task4 = new Epic ("Эпик1", " Подготовка к празднику 1", TaskStatus.NEW);

        SubTask task5 = new SubTask (" Подзадача", " составить список продуктов", TaskStatus.NEW,3);
        SubTask task6 = new SubTask (" Подзадача 1", " составить список продуктов 1", TaskStatus.NEW,3);
        SubTask task7 = new SubTask (" Подзадача 2", " составить список продуктов 2", TaskStatus.NEW,4);

        taskManager.addTask(task0);
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.addEpic( task3);
        taskManager.addEpic( task4);

        taskManager. addSubTask( task5);
        taskManager. addSubTask( task6);
        taskManager. addSubTask( task7);
        // Получили списки задач всех типов
        taskManager.printOllTasks();
        taskManager.printOllEpics();
        taskManager.printOllSubTasks();
    }


}
