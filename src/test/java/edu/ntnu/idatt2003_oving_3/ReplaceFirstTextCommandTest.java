package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReplaceFirstTextCommandTest {


    // ------- Positive tests -------


    @Test
    void execute_replaceFirstTextCommand() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("Hi","Hello");

        String result = cmd.execute("Hi Hi Hi");

        assertEquals("Hello Hi Hi", result);
    }

    // ------- Negative tests -------

    @Test
    void execute_throwsException_whenTextIsEmpty() {
        ReplaceFirstTextCommand cmd = new ReplaceFirstTextCommand("Hi", "Hello");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute(""));

        assertEquals("Text can't be empty", ex.getMessage());
    }


}
