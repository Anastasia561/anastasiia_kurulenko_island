package ua.javarush.island.engine;

import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameWorker {
    private static GameWorker instance;

    private GameWorker() {
    }

    public static GameWorker getInstance() {
        if (instance == null) {
            instance = new GameWorker();
        }
        return instance;
    }

    GameField gameField = AppConfigurator.getGameField();

    public void startGame() {
        for (int i = 0; i < gameField.getWidth(); i++) {
            for (int j = 0; j < gameField.getHeight(); j++) {
                Map<Type, Set<Organism>> residents = gameField.getCells()[i][j].getResidents();
                Set<Type> types = residents.keySet();
                for (Type type : types) {
                    Set<Organism> organisms = residents.get(type);
                    Set<Organism> clonedOrganisms = new HashSet<>();
                    for (Organism organism : organisms) {
                        clonedOrganisms.add(organism.clone());
                    }
                    for (Organism org:clonedOrganisms) {
                        org.play(gameField);
                    }
                }
            }
        }
    }
}
