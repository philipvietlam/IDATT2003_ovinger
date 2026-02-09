package edu.ntnu.idatt2003_oving_3;

public class ReplaceTextCommand implements TextCommand {
    protected String target;
    protected String replacement;

    public ReplaceTextCommand(String target, String replacement) {
        if(target.isEmpty()) {
            throw new IllegalArgumentException("Target can't be empty");
        }
        if(replacement.isEmpty()) {
            throw new IllegalArgumentException("Replacement can't be empty");
        }
        this.target = target;
        this.replacement = replacement;
    }

    public String getTarget(){
        return target;
    }

    public String getReplacement() {
        return replacement;
    }

    @Override
    public String execute(String text) {
        if(text.isEmpty()) {
            throw new IllegalArgumentException("Text can't be empty");
        }
        return text.replace(target, replacement);
    }



}

