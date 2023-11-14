package ua.javarush.island.statistics;

import lombok.Getter;
import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.configurator.GameObjectScanner;
import ua.javarush.island.console.ConsoleProvider;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.animal.Animal;
import ua.javarush.island.organism.animal.herbivore.Herbivore;
import ua.javarush.island.organism.animal.predator.Predator;
import ua.javarush.island.organism.plant.Plant;

import java.util.Set;

public class StatisticalProcessor {
    private static StatisticalProcessor instance;
    private GameObjectScanner gameObjectScanner = GameObjectScanner.getInstance();
    private ConsoleProvider consoleProvider = ConsoleProvider.getInstance();
    private int predators = 0;
    private int herbivores = 0;
    @Getter
    private int plants = 0;
    private int day = 0;
    GameField gameField = AppConfigurator.getGameField();
    private StatisticalProcessor() {
    }

    public static StatisticalProcessor getInstance() {
        if (instance == null) {
            instance = new StatisticalProcessor();
        }
        return instance;
    }

    private void countOrganisms() {
        predators = 0;
        herbivores = 0;
        plants = 0;
        Set<Class<? extends Predator>> predatorsSet = gameObjectScanner.getSpecialClasses(Predator.class);
        Set<Class<? extends Herbivore>> herbivoresSet = gameObjectScanner.getSpecialClasses(Herbivore.class);
        Set<Class<? extends Plant>> plantsSet = gameObjectScanner.getSpecialClasses(Plant.class);
        for (int i = 0; i < gameField.getWidth(); i++) {
            for (int j = 0; j < gameField.getHeight(); j++) {
                for (Class<? extends Predator> clazz : predatorsSet) {
                    predators += gameField.getCells()[i][j].getResidents().get(clazz).size();
                }
                for (Class<? extends Herbivore> clazz : herbivoresSet) {
                    herbivores += gameField.getCells()[i][j].getResidents().get(clazz).size();
                }
                for (Class<? extends Plant> clazz : plantsSet) {
                    plants += gameField.getCells()[i][j].getResidents().get(clazz).size();
                }
            }
        }
    }

    public void getStatistics() {
        consoleProvider.printToConsole("=".repeat(10));
        consoleProvider.printToConsole("Day: " + day);
        countOrganisms();
        consoleProvider.printToConsole("Animals died: " + Animal.getDiedAnimals());
        consoleProvider.printToConsole("Predators alive: " + predators);
        consoleProvider.printToConsole("Herbivores alive: " + herbivores);
        consoleProvider.printToConsole("Plants alive: " + plants);
        day++;
    }
}
