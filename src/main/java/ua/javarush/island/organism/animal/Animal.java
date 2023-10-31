package ua.javarush.island.organism.animal;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.field.GameField;
import ua.javarush.island.movingService.MovingService;
import ua.javarush.island.organism.Organism;

import java.util.Map;

@SuperBuilder
@NoArgsConstructor

public abstract class Animal extends Organism {
//    @Getter
//    int weight;
    @Getter
    int speed;
//    @Getter
//    int amount;
    @Getter
    int food;
    @Getter
    Map<String, Integer> matrix;
//    @Getter
//    Map<String, Integer> targetMatrix;

    @Override
    public void play() {

    }


}
