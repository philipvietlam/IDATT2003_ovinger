package edu.ntnu.idatt2003_oving_3;

public class CapitalizeTextCommand implements TextCommand{

    @Override
    public String execute(String text) {
        if(text.isEmpty()) {
            throw new IllegalArgumentException("Text can't be empty");
        }
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }
}
