package edu.ntnu.idatt2003_oving_3;

public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand{
    private String selection;

    public CapitalizeSelectionTextCommand(String selection) {
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }
    @Override
    public String execute(String text) {
        String select = getSelection();
        if(select.isEmpty()){
            throw new IllegalArgumentException("Text can't be empty");
        } else if(!text.contains(select)) {
            throw new IllegalArgumentException("Chose an eligible text to capitalize");
        }

        String capitalized = select.substring(0,1).toUpperCase() + select.substring(1);
        return text.replace(select,capitalized);
    }
}