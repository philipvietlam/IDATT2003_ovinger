package edu.ntnu.idatt2003_oving_3;

public class CapitalizeWordsCommand extends CapitalizeTextCommand{

    @Override
    public String execute (String text) {
        String [] newText = text.split(" ");
        for(int i = 0; i < newText.length; i++) {
            newText[i] = newText[i].substring(0,1).toUpperCase() + newText[i].substring(1);

        }
        return String.join(" ",newText);
    }
}

// hello world