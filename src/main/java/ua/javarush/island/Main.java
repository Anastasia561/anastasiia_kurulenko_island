package ua.javarush.island;

import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.console.ConsoleProvider;
import ua.javarush.island.engine.GameWorker;

public class Main {
    public static void main(String[] args) {
        ConsoleProvider.getInstance().printToConsole("Enter width of island: ");
        int width = ConsoleProvider.getInstance().readIntFromConsole();
        ConsoleProvider.getInstance().printToConsole("Enter length of island: ");
        int length = ConsoleProvider.getInstance().readIntFromConsole();
        AppConfigurator.getInstance().init(width, length);

        GameWorker.getInstance().play();
    }
}
