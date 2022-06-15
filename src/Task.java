public class Task {




        private String title;  // Наименование задачи
        private String description;  // Описание задачи
        private  int id = 0;
        private TaskStatus status;

    public Task(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String toString() {
        return title + " " + description + ", id=" + id +
                ", Статус=" + status;
    }

    public TaskStatus changeStatusOnDone() {
        status = TaskStatus.DONE;
        return status;
    }




}