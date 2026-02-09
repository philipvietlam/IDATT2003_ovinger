package edu.ntnu.idatt2003_oving_3;
import java.util.List;

public class Script implements TextCommand{
    private List<TextCommand> textCommands;

    public Script(List<TextCommand> textCommands) {
        if(textCommands == null || textCommands.isEmpty()) {
            throw new IllegalArgumentException("Text commands can't be null or empty");
        }
        this.textCommands = textCommands;
    }

    @Override
    public String execute(String text) {
        if(text.isEmpty()) {
            throw new IllegalArgumentException("Text can't be empty");
        }
        String result = text;

        for (TextCommand command : textCommands) {
            result = command.execute(result);
        }
        return result;
    }
}
