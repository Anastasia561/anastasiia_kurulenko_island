package ua.javarush.island.organism.animal.herbivorous;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;

@GameObjectEntity
@Config(filePath = "Caterpillar.yaml")
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class Caterpillar extends Herbivorous {
    @Override
    public Caterpillar reproduce() {
        return Caterpillar.builder()
                .normalWeight(this.getWeight())
                .weight(this.getNormalWeight())
                .speed(this.getSpeed())
                .food(this.getFood())
                .amount(this.getAmount())
                .stringTargetMatrix(this.getStringTargetMatrix())
                .build();
    }
}
