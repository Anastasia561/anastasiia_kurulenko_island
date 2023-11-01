package ua.javarush.island;

import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.engine.GameWorker;
import ua.javarush.island.organism.animal.Animal;
import ua.javarush.island.statistics.StatisticalProcessor;


public class Main {
    public static void main(String[] args) {
        AppConfigurator.getInstance().init();
        StatisticalProcessor.getInstance().count();
        GameWorker.getInstance().startGame();
        Animal.die(AppConfigurator.getGameField());
        StatisticalProcessor.getInstance().count();

    }

}