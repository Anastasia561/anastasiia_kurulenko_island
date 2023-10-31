package ua.javarush.island.organism.plant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.organism.Organism;

import java.util.Map;

@SuperBuilder
@NoArgsConstructor
public abstract class Plant extends Organism {
//    @Getter
//    int amount;
//    @Getter
//    int weight;
//    @Getter
//    Map<String, Integer> targetMatrix;

    @Override
    public void play() {

    }
}
