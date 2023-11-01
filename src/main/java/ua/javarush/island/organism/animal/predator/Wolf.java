package ua.javarush.island.organism.animal.predator;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;

@GameObjectEntity
@Config(filePath = "Wolf.yaml")
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class Wolf extends Predator {

    @Override
    public Wolf reproduce() {
        return Wolf.builder()
                .normalWeight(this.getWeight())
                .weight(this.getNormalWeight())
                .speed(this.getSpeed())
                .food(this.getFood())
                .amount(this.getAmount())
                .stringTargetMatrix(this.getStringTargetMatrix())
                .build();
    }


}
