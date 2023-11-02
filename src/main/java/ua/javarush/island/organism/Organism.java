package ua.javarush.island.organism;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.configurator.OrganismFactory;
import ua.javarush.island.field.Coordinate;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.animal.Animal;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
public abstract class Organism implements Cloneable {
    @Getter
    @Setter
    private Coordinate currentCoordinate;
    @Getter
    private int amount;
    @Getter
    @Setter
    private double weight;
    @Getter
    private double normalWeight;

    public abstract Organism reproduce();

    public abstract void play(GameField gameField);

    protected void reproduceOnCell(GameField gameField) {
        Map<Type, Set<Organism>> residents = gameField.getCells()[getCurrentCoordinate().getX()][getCurrentCoordinate().getY()].getResidents();
        Set<Organism> organismsOnCurrentCell = residents.get(this.getClass());
        if (checkPopulationOnCell(gameField, getCurrentCoordinate()) && organismsOnCurrentCell.size() > 1) {
            Organism organism = OrganismFactory.getInstance().create(this.getClass());
            organism.setCurrentCoordinate(getCurrentCoordinate());
            if(organism instanceof Animal){
                AppConfigurator.getInstance().createTargetMatrix((Animal) organism);
            }
            organismsOnCurrentCell.add(organism);
            //System.out.println(this.getClass().getSimpleName() + " " + "reproduced");
        }
    }

    protected boolean checkPopulationOnCell(GameField gameField, Coordinate coordinate) {
        Map<Type, Set<Organism>> residents = gameField.getCells()[coordinate.getX()]
                [coordinate.getY()].getResidents();
        Set<? extends Organism> organisms = residents.get(this.getClass());
        return (this.getAmount() > organisms.size());
    }

    @Override
    public Organism clone() {
        try {
            return (Organism) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }
}
