package ua.javarush.island.organism.plant;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;

@GameObjectEntity
@Config(filePath = "Grass.yaml")
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Grass extends Plant {
    @Override
    public Grass reproduce() {
        return Grass.builder()
                .normalWeight(this.getWeight())
                .weight(this.getNormalWeight())
                .amount(this.getAmount())
                .build();
    }
}
