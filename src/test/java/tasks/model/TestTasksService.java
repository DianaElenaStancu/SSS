package tasks.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tasks.services.TasksService;

import java.util.Date;
import java.util.List;

public class TestTasksService {

    @Mock
    Task task;

    @Mock
    ArrayTaskList taskList;

    TasksService tasksService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tasksService = new TasksService(taskList);

        Mockito.when(task.getTask()).thenReturn(new Task("Title", new Date(0), new Date(1), 2));
    }

    @Test
    public void Test1_getObservableList() {
        Mockito.when(taskList.getAll()).thenReturn(List.of(new Task("Title", new Date(0), new Date(1), 2)));
        Assertions.assertEquals(1, tasksService.getObservableList().size());
        Assertions.assertEquals(task.getTask(), tasksService.getObservableList().get(0));
    }

    @Test
    public void Test2_getIntervalInHours() {
        Mockito.when(task.getRepeatInterval()).thenReturn(1000);
        Assertions.assertEquals("00:16", tasksService.getIntervalInHours(task));
    }
}
