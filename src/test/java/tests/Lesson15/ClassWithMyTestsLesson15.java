package tests.Lesson15;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClassWithMyTestsLesson15 {

    @Test(groups = {"loginGroup"},
    description = "Test login with data provider",
    dataProvider = "UsersProvider")
    public void testLogin(String userName, String password, String role) {
        System.out.printf("Name: %s - password: %s - role: %s\n", userName, password, role);
    }

    @DataProvider(name = "UsersProvider")
    public String[][] getUsers() {
        return new String[][]{
                {"UserMisha", "123", "user"},
                {"adminHelena", "456", "admin"},
                {"guestOleg", "789", "guest"}
        };
    }

    @Test
    public void testNoGroupLoginDemo() {
        System.out.println("This will not execute during run suite due to this test hasn't group");
    }

    @Test(groups = {"loginGroup"},
            description = "Some failed test in group 'loginGroup'")
    public void someFailedTestInGroupLogin() {
        System.out.println("Some failed test in group 'loginGroup'");
//        Assert.fail("failing test as described at task");
        throw new RuntimeException("failing test as described at task");
    }

    @Test(dependsOnGroups = "loginGroup")
    public void secondTestDependOnGroupLogin() {
        System.out.println("Test will be ignored due to login group has failed test");
    }

    @Test(dependsOnGroups = "loginGroup", alwaysRun = true)
    public void thirdTestDependOnGroupLogin() {
        System.out.println("Test will be executed always due to alwaysRun = true");
    }

}
