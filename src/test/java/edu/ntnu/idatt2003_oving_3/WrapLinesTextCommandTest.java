package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WrapLinesTextCommandTest {

    // ------- Positive tests -------


    @Test
    void execute_wrapSelectionTextCommand() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("<p>","<p>");

        String result = cmd.execute("Hi Hi Hi world");

        assertEquals("<p>Hi<p> <p>Hi<p> <p>Hi<p> world", result);
    }


    // ------- Negative tests -------


    @Test
    void execute_throwsException_whenTextIsEmpty() {
        WrapLinesTextCommand cmd = new WrapLinesTextCommand("<p>", "<p>");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute(""));

        assertEquals("Text can't be empty", ex.getMessage());
    }




}
