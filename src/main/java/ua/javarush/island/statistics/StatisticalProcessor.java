package ua.javarush.island.statistics;

import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.configurator.GameObjectScanner;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;

import java.util.Set;

public class StatisticalProcessor {
    private static StatisticalProcessor instance;
    private StatisticalProcessor(){}
    public static StatisticalProcessor getInstance(){
        if(instance==null){
            instance=new StatisticalProcessor();
        }
        return instance;
    }

    GameField gameField = AppConfigurator.getGameField();
    public void count() {
        Set<Class<? extends Organism>> gameObjectClasses = GameObjectScanner.getInstance().getGameObjectClasses();
        for (int i = 0; i < gameField.getWidth(); i++) {
            for (int j = 0; j < gameField.getHeight(); j++) {
                for (Class<? extends Organism> clazz : gameObjectClasses) {
                    int size = gameField.getCells()[i][j].getResidents().get(clazz).size();
                    System.out.println(clazz.getSimpleName() + size);
                }
            }
        }
    }
}
