package ua.javarush.island.organism.animal.predator;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;

@GameObjectEntity
@Config(filePath = "Fox.yaml")
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class Fox extends Predator {
    @Override
    public Fox reproduce() {
        return Fox.builder()
                .normalWeight(this.getWeight())
                .weight(this.getNormalWeight())
                .speed(this.getSpeed())
                .food(this.getFood())
                .amount(this.getAmount())
                .stringTargetMatrix(this.getStringTargetMatrix())
                .build();
    }
}
