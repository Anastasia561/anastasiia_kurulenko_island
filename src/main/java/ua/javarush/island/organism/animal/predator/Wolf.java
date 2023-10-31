package ua.javarush.island.organism.animal.predator;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;
import ua.javarush.island.organism.Organism;
import ua.javarush.island.organism.animal.herbivorous.Horse;

@GameObjectEntity
@Config(filePath = "Wolf.yaml")
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class Wolf extends Predator {

    @Override
    public Wolf reproduce() {
        return Wolf.builder()
                .weight(this.getWeight())
                .speed(this.getSpeed())
                .food(this.getFood())
                .amount(this.getAmount())
                .matrix(this.getMatrix())
                .targetMatrix(this.getTargetMatrix())
                .build();
    }


}
