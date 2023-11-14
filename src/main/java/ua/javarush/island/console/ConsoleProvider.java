package ua.javarush.island.console;

import java.util.Scanner;

public class ConsoleProvider {
    private static ConsoleProvider instance;
    private ConsoleProvider(){}
    public static ConsoleProvider getInstance(){
        if(instance==null){
            instance=new ConsoleProvider();
        }
        return instance;
    }

    public void printToConsole(String message){
        System.out.println(message);
    }

    public int readIntFromConsole(){
       return new Scanner(System.in).nextInt();
    }
}
