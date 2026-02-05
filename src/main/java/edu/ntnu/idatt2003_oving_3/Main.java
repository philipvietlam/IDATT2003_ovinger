package edu.ntnu.idatt2003_oving_3;

public class Main {
    static void main(String[] args) {
       String result = new ReplaceTextCommand("target","replacement").execute("Jeg har target og en target og en target");
       System.out.print(result);
       String result2 = new ReplaceFirstTextCommand(".","replacement").execute("Jeg har en target som. liker en target som er en target");
       System.out.println(result2);
    }


}