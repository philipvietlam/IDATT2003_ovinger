package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WrapSelectionTextCommandTest {


    // ------- Positive tests -------


    @Test
    void constructor_validInstance() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("<p>", "<p>","Hi");

        assertEquals("<p>",cmd.getOpening());
        assertEquals("<p>",cmd.getEnd());
        assertEquals("Hi",cmd.getSelection());
    }


    @Test
    void execute_wrapSelectionTextCommand() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("<p>","<p>","Hi");

        String result = cmd.execute("Hi Hi Hi world");

        assertEquals("<p>Hi<p> <p>Hi<p> <p>Hi<p> world", result);
    }


    // ------- Negative tests -------


    @Test
    void constructor_throwsException_whenSelectionIsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new WrapSelectionTextCommand("<p>", "<p>",""));

        assertEquals("Selection can't be empty",ex.getMessage());
    }

    @Test
    void execute_throwsException_whenTextIsEmpty() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("<p>", "<p>","Hi");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute(""));

        assertEquals("Text can't be empty", ex.getMessage());
    }

    @Test
    void execute_throwsException_whenTextDoesNotContainSelection() {
        WrapSelectionTextCommand cmd = new WrapSelectionTextCommand("<p>", "<p>","Hi");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute("Hello"));

        assertEquals("Text does not contain selection", ex.getMessage());
    }


}
