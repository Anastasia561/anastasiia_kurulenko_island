package ua.javarush.island.organism.plant;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;
import ua.javarush.island.organism.Organism;
import ua.javarush.island.organism.animal.herbivorous.Horse;
import ua.javarush.island.organism.plant.Plant;

@GameObjectEntity
@Config(filePath = "Grass.yaml")
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Grass extends Plant {
    @Override
    public Grass reproduce() {
        return Grass.builder()
                .weight(this.getWeight())
                .amount(this.getAmount())
                .targetMatrix(this.getTargetMatrix())
                .build();
    }


}
