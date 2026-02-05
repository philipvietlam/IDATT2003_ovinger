package edu.ntnu.idatt2003_oving_3;

import java.util.List;

public class Main {
    static void main(String[] args) {
       String result = new ReplaceTextCommand("target","replacement").execute("I am at target, shooting a target ");
       System.out.print(result);


       String result2 = new ReplaceFirstTextCommand(".","Adele").execute("Hello . It's me.");
       System.out.println(result2);

       String result3 = new WrapTextCommand("<p>", "<p>").execute("Paragraph");
       System.out.println(result3);

       String result4 = new WrapLinesTextCommand("<p>","<p>").execute(" I \n don't \n have \n teeth ");
       System.out.println(result4);

       String result5 = new WrapSelectionTextCommand("<p>","<p>","selection").execute("I have a big selection of toys");
       System.out.println(result5);

       String result6 = new CapitalizeTextCommand().execute("hello world");
       System.out.println(result6);

        String result7 = new CapitalizeWordsCommand().execute("hello world my name is john");
        System.out.println(result7);

        String result8 = new CapitalizeSelectionTextCommand("john").execute("hello world my name is john john john");
        System.out.println(result8);

        List<TextCommand> textCommands = List.of(new CapitalizeTextCommand(),new WrapTextCommand("<p>","<p>"));


        String result9 = new Script(textCommands).execute("hello world");
        System.out.println(result9);
    }


}