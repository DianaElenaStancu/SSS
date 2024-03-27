package tasks.services;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import tasks.model.ArrayTaskList;
import tasks.model.Task;

import java.util.Date;

public class TaskServiceTest {
    private static TasksService service;

    @BeforeAll
    static void generalSetUp() {
    }

    @AfterAll
    static void bigCleaning() {

    }

    @BeforeEach
    void testSetup() {
        ArrayTaskList tasks = new ArrayTaskList();
        service = new TasksService(tasks);
    }

    @AfterEach
    void testCleaning() {
        service = null;
    }

    @Test
    public void sampleTest() {
        Assertions.assertEquals(2, 3 - 1);
    }

    @Test
    @Tag("bva")
    public void saveTaskWithValidTitle() {
        Task task = new Task("Title", new Date(), new Date(), 1);

        try {
            service.saveTask(task);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        assert(service.getTasks().size() == 1);
        assert(service.getTasks().getTask(0) == task);
    }

    @Test
    @Tag("bva")
    public void saveTaskWithValidDate() {
        Task task = new Task("Title", new Date(), new Date(), 1);

        try {
            service.saveTask(task);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(service.getTasks().toString());
        assert(service.getTasks().size() == 1);
        assert(service.getTasks().getTask(0) == task);
    }

    @Test
    @Tag("bva")
    public void saveTaskWithInvalidTitleLowerBound() {
        Task task = new Task("", new Date(), new Date(), 1);

        try {
            service.saveTask(task);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        assert(service.getTasks().size() == 0);
    }

    @Test
    @Tag("bva")
    public void saveTaskWithInvalidTitleUpperBound() {
        Task task = new Task("wLhIUEnLeKNcsrv7oFQqpr2gznG41jQdaWE5MYp1x2Z88PEuaCegF3dSr3ScuuwzzFfT5Fj6Zah8etTUXrRiUau9qfLJZxqwqMoaDv6TT6mG8V2V20BrOlYlV1w2A50sREW5YFRA5N4cY1UMF7NMZN5KTeSCWskqlz5gKbdFbQaMj6P2ZZ3xqHlBH4eDfbrpKD6RJB3i4rASxpJ3RSNNMX0rG4uYJrnuCWlkFiEtjzd3yhVrkIlIwIpw4U9oH6Yt", new Date(), new Date(), 1);

        try {
            service.saveTask(task);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        assert(service.getTasks().size() == 0);
    }

    /*nu se poate testa cazul date before 1970 pentru ca nu se poate crea un task cu o asemenea data*/
    @Test
    @Tag("bva")
    public void saveTaskWithInvalidDate() {
        try {
            Task task = new Task("Title", new Date(69, 11, 31), new Date(69, 11, 31), 1);
        } catch(IllegalArgumentException illegalArgumentException) {
            assert (illegalArgumentException.getMessage().equals("Time cannot be negative"));
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
