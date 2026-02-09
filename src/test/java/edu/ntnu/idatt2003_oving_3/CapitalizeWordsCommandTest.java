package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CapitalizeWordsCommandTest {
    // ------- Positive tests -------


    @Test
    void execute_capitalizeWordsCommand() {
        CapitalizeWordsCommand cmd = new CapitalizeWordsCommand();

        String result = cmd.execute("hello my name is phil");

        assertEquals("Hello My Name Is Phil", result);
    }

    // ------- Negative tests -------

    @Test
    void execute_throwsException_whenTextIsEmpty() {
        CapitalizeWordsCommand cmd = new CapitalizeWordsCommand();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cmd.execute(""));

        assertEquals("Text can't be empty", ex.getMessage());
    }
}
