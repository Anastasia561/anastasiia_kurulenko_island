package ua.javarush.island.organism.plant;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;

@SuperBuilder
@NoArgsConstructor
public abstract class Plant extends Organism {

    @Override
    public void play(GameField gameField) {
        reproduceOnCell(gameField);
    }
}
