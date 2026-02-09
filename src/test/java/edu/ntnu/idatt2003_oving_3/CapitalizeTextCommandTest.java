package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CapitalizeTextCommandTest {

    // ------- Positive tests -------


    @Test
    void execute_capitalizeTextCommand() {
        CapitalizeTextCommand cmd = new CapitalizeTextCommand();

        String result = cmd.execute("hello");

        assertEquals("Hello", result);
    }

    // ------- Negative tests -------

    @Test
    void execute_throwsException_whenTextIsEmpty() {
        CapitalizeTextCommand cmd = new CapitalizeTextCommand();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute(""));

        assertEquals("Text can't be empty", ex.getMessage());
    }

}
