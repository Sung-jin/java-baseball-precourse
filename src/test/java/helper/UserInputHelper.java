package helper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserInputHelper {

    private UserInputHelper() {}

    public static void mockUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
