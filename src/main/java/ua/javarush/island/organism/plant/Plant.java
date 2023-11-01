package ua.javarush.island.organism.plant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;

import java.util.Map;

@SuperBuilder
@NoArgsConstructor
public abstract class Plant extends Organism {

    @Override
    public void play(GameField gameField) {
        System.out.println("grass played");
    }
}
