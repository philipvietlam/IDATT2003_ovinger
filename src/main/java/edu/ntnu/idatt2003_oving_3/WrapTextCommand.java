package edu.ntnu.idatt2003_oving_3;

public class WrapTextCommand implements TextCommand {
    protected String opening;
    protected String end;

    public WrapTextCommand(String opening, String end) {
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
        return opening + text + end;
    }
}
