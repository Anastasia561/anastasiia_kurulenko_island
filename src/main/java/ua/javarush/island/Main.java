package ua.javarush.island;

import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.console.ConsoleProvider;
import ua.javarush.island.engine.GameWorker;
import ua.javarush.island.organism.animal.Animal;
import ua.javarush.island.statistics.StatisticalProcessor;

public class Main {
    public static void main(String[] args) {
        ConsoleProvider.getInstance().printToConsole("Enter width of island: ");
        int width  = ConsoleProvider.getInstance().readIntFromConsole();
        ConsoleProvider.getInstance().printToConsole("Enter length of island: ");
        int length = ConsoleProvider.getInstance().readIntFromConsole();
        AppConfigurator.getInstance().init(width, length);
        //StatisticalProcessor.getInstance().count();
        //StatisticalProcessor.getInstance().getStatistics();
        //GameWorker.getInstance().startGame();
        //Animal.die(AppConfigurator.getGameField());
        //StatisticalProcessor.getInstance().getStatistics();
        //StatisticalProcessor.getInstance().count();
        //GameWorker.getInstance().play();
        StatisticalProcessor.getInstance().getStatistics();
        while(true){
            GameWorker.getInstance().startGame();
            StatisticalProcessor.getInstance().getStatistics();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
