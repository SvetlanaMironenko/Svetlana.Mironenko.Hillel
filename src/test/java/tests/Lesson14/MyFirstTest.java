package tests.Lesson14;

import hillel.lesson08.Logger;
import org.testng.annotations.Test;

public class MyFirstTest {

    @Test
    public void SomeOfTest() {
        Logger.info("Test started");

        //Test something

        Logger.info("My First test passed");
    }

}
