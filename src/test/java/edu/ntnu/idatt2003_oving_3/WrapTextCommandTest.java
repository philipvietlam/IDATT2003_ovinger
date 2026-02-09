package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WrapTextCommandTest {


    // ------- Positive tests -------

    @Test
    void constructor_validInstance() {
        WrapTextCommand cmd = new WrapTextCommand("<p>", "<p>");

        assertEquals("<p>",cmd.getOpening());
        assertEquals("<p>",cmd.getEnd());
    }

    @Test
    void execute_wrapTextCommand() {
        WrapTextCommand cmd = new WrapTextCommand("<p>","<p>");

        String result = cmd.execute("Hi world");

        assertEquals("<p>Hi world<p>", result);
    }


    // ------- Negative tests -------

    @Test
    void constructor_throwsException_whenOpeningIsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new WrapTextCommand("", "<p>"));

        assertEquals("Opening can't be empty",ex.getMessage());
    }

    @Test
    void constructor_throwsException_whenEndIsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new WrapTextCommand("<p>", ""));

        assertEquals("End can't be empty",ex.getMessage());
    }
    @Test
    void execute_throwsException_whenTextIsEmpty() {
        WrapTextCommand cmd = new WrapTextCommand("<p>", "<p>");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute(""));

        assertEquals("Text can't be empty", ex.getMessage());
    }

}


