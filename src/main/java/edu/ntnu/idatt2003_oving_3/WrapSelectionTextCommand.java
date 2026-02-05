package edu.ntnu.idatt2003_oving_3;

public class WrapSelectionTextCommand extends WrapTextCommand{
private String selection;
    public WrapSelectionTextCommand(String opening, String end, String selection) {
        super(opening, end);
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }

    @Override
    public String execute(String text) {
        String wrappedWord = "";
        if (text.contains(selection)) {
            wrappedWord = getOpening() + selection + getEnd();
        }
        return text.replaceFirst(selection,wrappedWord);
    }
}
