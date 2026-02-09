package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CapitalizeSelectionTextCommandTest {
    // ------- Positive tests -------


    @Test
    void constructor_validInstance() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hello");

        assertEquals("hello", cmd.getSelection());
    }


    @Test
    void execute_capitalizeSelectionTextCommand() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hello");

        String result = cmd.execute("hello");

        assertEquals("Hello", result);
    }

    // ------- Negative tests -------


    @Test
    void constructor_throwsException_whenSelectionIsEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new CapitalizeSelectionTextCommand(""));

        assertEquals("Selection can't be empty",ex.getMessage());
    }


    @Test
    void execute_throwsException_whenTextIsEmpty() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hello");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute(""));

        assertEquals("Text can't be empty", ex.getMessage());
    }



    @Test
    void execute_throwsException_whenTextDoesNotContainSelection() {
        CapitalizeSelectionTextCommand cmd = new CapitalizeSelectionTextCommand("hi");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute("Hello"));

        assertEquals("Chose an eligible text to capitalize", ex.getMessage());
    }





}
