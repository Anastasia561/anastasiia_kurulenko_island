package ua.javarush.island.engine;

import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;
import ua.javarush.island.tasks.SimulateIslandTask;
import ua.javarush.island.tasks.StatisticTask;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
                    Set<Organism> clonedOrganisms = cloneOrganismsSet(organisms);
                    for (Organism org : clonedOrganisms) {
                        org.play(gameField);
                    }
                }
            }
        }
    }

    private Set<Organism> cloneOrganismsSet(Set<Organism> organisms) {
        Set<Organism> clonedOrganisms = new HashSet<>();
        for (Organism organism : organisms) {
            clonedOrganisms.add(organism.clone());
        }
        return clonedOrganisms;
    }

    public void play() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(new StatisticTask(), 0, 2, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(new SimulateIslandTask(), 1, 2, TimeUnit.SECONDS);
    }
}
