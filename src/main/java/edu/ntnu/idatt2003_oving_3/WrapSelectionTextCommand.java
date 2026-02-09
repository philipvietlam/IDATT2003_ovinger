package edu.ntnu.idatt2003_oving_3;

import java.util.regex.Pattern;

public class WrapSelectionTextCommand extends WrapTextCommand{
private String selection;

    public WrapSelectionTextCommand(String opening, String end, String selection) {
        super(opening, end);

        if(selection.isEmpty()) {
            throw new IllegalArgumentException("Selection can't be empty");
        }
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }

    @Override
    public String execute(String text) {
        if(text.isEmpty()) {
            throw new IllegalArgumentException("Text can't be empty");
        }
        String wrappedWord;
        if(!text.contains(getSelection())) {
            throw new IllegalArgumentException("Text does not contain selection");
        }
        wrappedWord = getOpening() + getSelection() + getEnd();

        return text.replace(getSelection(),wrappedWord);
    }
}
