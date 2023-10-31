package ua.javarush.island.organism;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@SuperBuilder
@NoArgsConstructor
public abstract class Organism implements GameObject{
    @Getter
    int amount;
    @Getter
    int weight;
    @Getter
    Map<String, Integer> targetMatrix;

    public abstract Organism reproduce();

}
