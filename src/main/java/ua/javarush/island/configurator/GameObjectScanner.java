package ua.javarush.island.configurator;

import org.reflections.Reflections;
import ua.javarush.island.annotations.GameObjectEntity;
import ua.javarush.island.organism.Organism;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameObjectScanner {
    private static GameObjectScanner instance;

    private static final Reflections reflections = new Reflections("ua.javarush.island");

    private GameObjectScanner() {
    }

    public static GameObjectScanner getInstance() {
        if (instance == null) {
            instance = new GameObjectScanner();
        }
        return instance;
    }

    public Set<Class<? extends Organism>> getGameObjectClasses() {
        HashSet<Class<? extends Organism>> set = new HashSet<>();
        return reflections.getSubTypesOf(Organism.class)
                .stream()
                .filter(c -> c.isAnnotationPresent(GameObjectEntity.class))
                .collect(Collectors.toSet());
    }
}
