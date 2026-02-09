package edu.ntnu.idatt2003_oving_3;
import java.util.regex.Pattern;

public class ReplaceFirstTextCommand extends ReplaceTextCommand{

    public ReplaceFirstTextCommand(String target, String replacement) {
        super(target, replacement);
    }

    @Override
    public String execute(String text) {
        if(text.isEmpty()) {
            throw new IllegalArgumentException("Text can't be empty");
        }
        return text.replaceFirst(Pattern.quote(getTarget()), getReplacement());
    }
}
