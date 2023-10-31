package ua.javarush.island.field;

import ua.javarush.island.organism.Organism;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cell {
     private final  Map<Type, Set<? extends Organism>> residents = new HashMap<>();
     Coordinate coordinate;

     public Cell(Coordinate coordinate) {
          this.coordinate = coordinate;
     }

     public Map<Type, Set<? extends Organism>> getResidents() {
          return residents;
     }
}
