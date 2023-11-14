package ua.javarush.island.field;

import lombok.Getter;
import ua.javarush.island.organism.Organism;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cell {
    @Getter
    private final Map<Type, Set<Organism>> residents = new HashMap<>();
    Coordinate coordinate;

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
