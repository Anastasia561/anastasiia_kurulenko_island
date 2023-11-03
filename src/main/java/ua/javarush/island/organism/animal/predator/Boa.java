package ua.javarush.island.organism.animal.predator;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;

@GameObjectEntity
@Config(filePath = "Boa.yaml")
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class Boa extends Predator {
    @Override
    public Boa reproduce() {
        return Boa.builder()
                .normalWeight(this.getWeight())
                .weight(this.getNormalWeight())
                .speed(this.getSpeed())
                .food(this.getFood())
                .amount(this.getAmount())
                .stringTargetMatrix(this.getStringTargetMatrix())
                .build();
    }
}
