package ua.javarush.island.organism.animal.herbivorous;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;
import ua.javarush.island.organism.Organism;

@GameObjectEntity
@Config(filePath = "Horse.yaml")
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Horse extends Herbivorous {

    @Override
    public Horse reproduce() {
        return Horse.builder()
                .weight(this.getWeight())
                .speed(this.getSpeed())
                .food(this.getFood())
                .amount(this.getAmount())
                .matrix(this.getMatrix())
                .targetMatrix(this.getTargetMatrix())
                .build();
    }
}
