package tasks.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskIntegrationTest {

    @Nested
    class ServiceWithRepositoryIntegration {
        @Mock
        Task task;

        ArrayTaskList taskList;

        TasksService tasksService;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.initMocks(this);
            taskList = new ArrayTaskList();
            tasksService = new TasksService(taskList);

            Mockito.when(task.getTask()).thenReturn(new Task("Title", new Date(0), new Date(1), 2));
        }

        @Test
        public void Test1_getObservableList() {
            taskList.add(task.getTask());
            Assertions.assertEquals(1, tasksService.getObservableList().size());
            Assertions.assertEquals(task.getTask(), tasksService.getObservableList().get(0));
        }

        @Test
        public void Test2_getIntervalInHours() {
            Mockito.when(task.getRepeatInterval()).thenReturn(1000);
            Assertions.assertEquals("00:16", tasksService.getIntervalInHours(task));
        }
    }

    @Nested
    class ServiceWithRepositoryWithDomainIntegration {
        Task task = new Task("a", new Date(0), new Date(1), 1000);

        ArrayTaskList taskList;

        TasksService tasksService;

        @BeforeEach
        public void setUp() {
            taskList = new ArrayTaskList();
            tasksService = new TasksService(taskList);
        }

        @Test
        public void Test1_getObservableList() {
            taskList.add(task.getTask());
            Assertions.assertEquals(1, tasksService.getObservableList().size());
            Assertions.assertEquals(task.getTask(), tasksService.getObservableList().get(0));
        }

        @Test
        public void Test2_getIntervalInHours() {
            Assertions.assertEquals("00:16", tasksService.getIntervalInHours(task));
        }
    }
}
