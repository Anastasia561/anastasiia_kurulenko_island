package ua.javarush.island.organism.animal.herbivorous;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;
import ua.javarush.island.organism.Organism;

@GameObjectEntity
@Config(filePath = "Caterpillar.yaml")
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class Caterpillar extends Herbivorous {
    @Override
    public Caterpillar reproduce() {
        return  Caterpillar.builder()
                .weight(this.getWeight())
                .speed(this.getSpeed())
                .food(this.getFood())
                .amount(this.getAmount())
                .matrix(this.getMatrix())
                .targetMatrix(this.getTargetMatrix())
                .build();
    }
}
