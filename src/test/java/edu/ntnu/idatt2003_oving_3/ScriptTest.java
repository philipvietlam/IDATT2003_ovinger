package edu.ntnu.idatt2003_oving_3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScriptTest {

    // ------- Positive tests -------


    @Test
    void constructor_validInstance() {

        List<TextCommand> commands = List.of(
                text -> text
        );

        Script script = new Script(commands);

        assertNotNull(script);
    }

    @Test
    void execute_script() {
        TextCommand replace = new ReplaceTextCommand("hi", "hello");
        TextCommand capitalize = new CapitalizeTextCommand();

        Script script = new Script(List.of(replace, capitalize));

        String result = script.execute("hi my name is phil");

        assertEquals(" Hello my Name is phil", result);
    }



    // ------- Negative tests -------

    @Test
    void constructor_throwsException_whenListIsNull() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Script(null)
        );

        assertEquals("Text commands can't be null or empty", ex.getMessage());
    }

    @Test
    void constructor_throwsException_whenListIsEmpty() {
        List<TextCommand> emptyList = List.of();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Script(emptyList)
        );

        assertEquals("Text commands can't be null or empty", ex.getMessage());
    }

    @Test
    void execute_throwsException_whenTextIsEmpty() {
        Script script = new Script(List.of(
                text -> text
        ));

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> script.execute("")
        );

        assertEquals("Text can't be empty", ex.getMessage());
    }







}
