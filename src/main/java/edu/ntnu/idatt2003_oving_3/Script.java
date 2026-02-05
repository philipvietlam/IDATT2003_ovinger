package edu.ntnu.idatt2003_oving_3;
import java.util.List;

public class Script implements TextCommand{
    private List<TextCommand> textCommands;

    public Script(List<TextCommand> textCommands) {
        this.textCommands = textCommands;
    }

    @Override
    public String execute(String text) {
        String result = text;

        for (TextCommand command : textCommands) {
            result = command.execute(result);
        }
        return result;
    }
}
