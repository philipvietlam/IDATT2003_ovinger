package edu.ntnu.idatt2003_oving_3;

public class WrapLinesTextCommand extends WrapTextCommand{

    public WrapLinesTextCommand(String opening, String end) {
        super(opening, end);
    }

    @Override
    public String execute(String text) {
        String [] newText = text.split("\n");
        for(int i = 0; i < newText.length; i++) {
            newText[i] = getOpening() + newText[i] + getEnd();
        }
        return String.join("\n",newText);

    }
}
