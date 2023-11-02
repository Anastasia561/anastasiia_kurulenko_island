package ua.javarush.island.tasks;

import ua.javarush.island.engine.GameWorker;
import ua.javarush.island.field.GameField;

public class SimulateIslandTask implements Runnable{
    @Override
    public void run() {
        GameWorker.getInstance().startGame();
    }
}
