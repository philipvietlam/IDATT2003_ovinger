package edu.ntnu.idatt2003_oving_3;

public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand{
    private String selection;

    public CapitalizeSelectionTextCommand(String selection) {
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

        String select = getSelection();

        if(!text.contains(select)) {
            throw new IllegalArgumentException("Chose an eligible text to capitalize");
        }

        String capitalized = select.substring(0,1).toUpperCase() + select.substring(1);
        return text.replace(select,capitalized);
    }
}