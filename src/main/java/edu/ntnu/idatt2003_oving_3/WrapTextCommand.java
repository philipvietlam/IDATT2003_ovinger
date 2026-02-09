package edu.ntnu.idatt2003_oving_3;

public class WrapTextCommand implements TextCommand {

    protected String opening;
    protected String end;

    public WrapTextCommand(String opening, String end) {
        if(opening.isEmpty()) {
            throw new IllegalArgumentException("Opening can't be empty");
        }
        if(end.isEmpty()) {
            throw new IllegalArgumentException("End can't be empty");
        }
        this.opening = opening;
        this.end = end;
    }

    public String getOpening() {
        return opening;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public String execute(String text) {
        if(text.isEmpty()) {
            throw new IllegalArgumentException("Text can't be empty");
        }
        return opening + text + end;
    }
}
