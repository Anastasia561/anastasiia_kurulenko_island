package ua.javarush.island.organism;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.field.Coordinate;
import ua.javarush.island.field.GameField;

import java.util.Map;

@SuperBuilder
@NoArgsConstructor
public abstract class Organism {
    @Getter
    @Setter
    private Coordinate currentCoordinate;
    @Getter
    private int amount;
    @Getter
    @Setter
    private int weight;
    @Getter
    private int normalWeight;

    public abstract Organism reproduce();

    public abstract void play(GameField gameField);

}
