package tasks.services;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TaskServiceTest {
    @BeforeAll
    static void generalSetUp() {

    }

    @BeforeEach
    void testSetup() {

    }

    @Test
    public void sampleTest() {
        Assertions.assertEquals(2, 3 - 1);
    }


    @AfterEach
    void testCleaning() {

    }

    @AfterAll
    static void bigCleaning() {

    }

}
