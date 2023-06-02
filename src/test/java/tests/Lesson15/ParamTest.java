package tests.Lesson15;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

    @Test(description = "Demo with param test")
    @Parameters({"domain", "language"})
    public void testWithParameters(String domain, String language) {
        System.out.println("The test has parameters " + domain + " " + language);
    }

}
