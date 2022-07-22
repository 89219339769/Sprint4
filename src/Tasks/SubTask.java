package Tasks;

import Tasks.Task;
import Tasks.TaskStatus;

public class SubTask extends Task {
int epicId;

    public SubTask(String title, String description, TaskStatus status, int epicId ) {
        super(title, description, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

}
