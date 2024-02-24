package ua.javarush.island.configurator;

import lombok.Getter;
import ua.javarush.island.field.Coordinate;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;
import ua.javarush.island.organism.animal.Animal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class AppConfigurator {

    private static AppConfigurator instance;

    @Getter
    private static GameField gameField;

    private static final GameObjectScanner gameObjectScanner = GameObjectScanner.getInstance();

    private static final GameObjectLoader gameObjectLoader = GameObjectLoader.getInstance();

    private static final OrganismFactory organismFactory = OrganismFactory.getInstance();

    private AppConfigurator() {
    }

    public static AppConfigurator getInstance() {
        if (instance == null) {
            instance = new AppConfigurator();
        }
        return instance;
    }

    public void init(int width, int height) {
        registerPrototypes();
        createGameField(width, height);
        placeOrganisms();
    }

    private void registerPrototypes() {
        gameObjectScanner.getGameObjectClasses()
                .stream()
                .map(gameObjectLoader::loadPrototype)
                .forEach(organismFactory::registerPrototype);
    }

    private void createGameField(int width, int height) {
        gameField = new GameField(width, height);
        gameField.createCells();
    }

    private void placeOrganisms() {
        Set<Class<? extends Organism>> gameObjectClasses = gameObjectScanner.getGameObjectClasses();
        for (int i = 0; i < gameField.getWidth(); i++) {
            for (int j = 0; j < gameField.getHeight(); j++) {
                for (Class<? extends Organism> clazz : gameObjectClasses) {
                    Set<Organism> organisms = generateRandomAmount(clazz);
                    gameField.getCells()[i][j].getResidents().put(clazz, organisms);
                    for (Organism organism : organisms) {
                        organism.setCurrentCoordinate(new Coordinate(i, j));
                    }
                }
            }
        }
    }

    private Set<Organism> generateRandomAmount(Class<? extends Organism> clazz) {
        Set<Organism> organisms = new HashSet<>();
        int amount = gameObjectLoader.loadPrototype(clazz).getAmount();
        int randomNumber = ThreadLocalRandom.current().nextInt(0, amount);
        for (int i = 0; i < randomNumber; i++) {
            Organism organism = organismFactory.create(clazz);
            if (organism instanceof Animal) {
                createTargetMatrix((Animal) organism);
            }
            organisms.add(organism);
        }
        return organisms;
    }

    public void createTargetMatrix(Animal animal) {
        Set<Class<? extends Organism>> gameObjectClasses = gameObjectScanner.getGameObjectClasses();
        Map<String, Integer> stringTargetMatrix = animal.getStringTargetMatrix();
        Map<Class<? extends Organism>, Integer> targetMatrix = new HashMap<>();
        for (String str : stringTargetMatrix.keySet()) {
            for (Class<? extends Organism> clazz : gameObjectClasses) {
                if (str.equals(clazz.getSimpleName())) {
                    targetMatrix.put(clazz, stringTargetMatrix.get(str));
                }
            }
        }
        animal.setTargetMatrix(targetMatrix);
    }
}
