package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ReplaceTextCommandTest {



    // ------- Positive tests -------


    @Test
    void constructor_validInstance() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("Hi","Hello");

        assertEquals("Hi",cmd.getTarget());
        assertEquals("Hello",cmd.getReplacement());

    }



    @Test
    void execute_replaceTextCommand() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("Hi","Hello");

        String result = cmd.execute("Hi world");

        assertEquals("Hello world", result);
    }



    // ------- Negative tests -------


    @Test
    void constructor_throwsException_whenTargetIsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ReplaceTextCommand("", "Hello"));

        assertEquals("Target can't be empty",ex.getMessage());
    }

    @Test
    void constructor_throwsException_whenReplacementIsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ReplaceTextCommand("Hello", ""));

        assertEquals("Replacement can't be empty",ex.getMessage());
    }

    @Test
    void execute_throwsException_whenTextIsEmpty() {
        ReplaceTextCommand cmd = new ReplaceTextCommand("Hi", "Hello");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute(""));

        assertEquals("Text can't be empty", ex.getMessage());
    }

}
