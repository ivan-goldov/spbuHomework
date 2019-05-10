package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    @Test
    public void additionTest() {
        String[] strings = new String[] {"abc", "a b c"};
        Application application = new Application();
        application.add(strings);
    }

}