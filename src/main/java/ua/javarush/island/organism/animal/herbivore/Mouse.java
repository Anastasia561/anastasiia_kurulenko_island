package ua.javarush.island.organism.animal.herbivore;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;

@GameObjectEntity
@Config(filePath = "Mouse.yaml")
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Mouse extends Herbivore {
    @Override
    public Mouse reproduce() {
        return Mouse.builder()
                .normalWeight(this.getWeight())
                .weight(this.getNormalWeight())
                .speed(this.getSpeed())
                .food(this.getFood())
                .amount(this.getAmount())
                .stringTargetMatrix(this.getStringTargetMatrix())
                .build();
    }
}
