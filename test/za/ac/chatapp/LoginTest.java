import chatapppoe.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {


    @Test
    public void testRegisterUserSuccess() {
        Login login = new Login();
        login.username = "kyl_1";
        login.password = "Ch&&sec@ke99|";
        login.cellPhoneNumber = "+27838968976";
        assertEquals("User has been registered successfully.", login.registerUser());
    }

    @Test
    public void testIncorrectUsernameMessage() {
        Login login = new Login();
        login.username = "kyle!!!!!!!"; // Invalid
        login.password = "Ch&&sec@ke99|"; // Valid
        login.cellPhoneNumber = "+27838968976"; // Valid
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", login.registerUser());
    }

    @Test
    public void testIncorrectPasswordMessage() {
        Login login = new Login();
        login.username = "kyl_1"; // Valid
        login.password = "password"; // Invalid
        login.cellPhoneNumber = "+27838968976"; // Valid
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", login.registerUser());
    }

    @Test
    public void testIncorrectCellPhoneMessage() {
        Login login = new Login();
        login.username = "kyl_1"; // Valid
        login.password = "Ch&&sec@ke99|"; // Valid
        login.cellPhoneNumber = "08966553"; // Invalid
        assertEquals("Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.", login.registerUser());
    }

    @Test
    public void testSuccessfulLoginMessage() {
        Login login = new Login();
        login.username = "kyl_1";
        login.password = "Ch&&sec@ke99|";
        login.firstName = "Kyle";
        login.lastName = "Smith";
        boolean loginResult = login.loginUser("kyl_1", "Ch&&sec@ke99|");
        assertEquals("Welcome Kyle, Smith it is great to see you again.", login.returnLoginStatus(loginResult));
    }

    @Test
    public void testFailedLoginMessage() {
        Login login = new Login();
        boolean loginResult = login.loginUser("kyl_1", "wrongpass");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(loginResult));
    }
}
