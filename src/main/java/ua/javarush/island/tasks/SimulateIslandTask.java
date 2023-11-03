package ua.javarush.island.tasks;

import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.engine.GameWorker;
import ua.javarush.island.organism.animal.Animal;

public class SimulateIslandTask implements Runnable{
    @Override
    public void run() {
        GameWorker.getInstance().startGame();
        Animal.die(AppConfigurator.getGameField());
    }
}
