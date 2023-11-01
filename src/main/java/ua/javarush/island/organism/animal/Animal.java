package ua.javarush.island.organism.animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ua.javarush.island.field.Coordinate;
import ua.javarush.island.field.Direction;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SuperBuilder
@NoArgsConstructor

public abstract class Animal extends Organism {
    @Getter
    private int speed;
    @Getter
    private int food;
    @Getter
    private Map<String, Integer> stringTargetMatrix;
    @Getter
    @Setter
    private Map<Class<? extends Organism>, Integer> targetMatrix;
    private static int diedAnimals;

    private void reproduceOnCell(GameField gameField) {
        if (checkPopulationOnCell(gameField, getCurrentCoordinate())) {
            //this.reproduce();
            Map<Type, Set<Organism>> residents = gameField.getCells()[getCurrentCoordinate().getX()][getCurrentCoordinate().getY()].getResidents();
            residents.get(this.getClass()).add(this);
            System.out.println(this.getClass().getSimpleName() + " " + "reproduced");
        }
    }

    private boolean checkPopulationOnCell(GameField gameField, Coordinate coordinate) {
        Map<Type, Set<Organism>> residents = gameField.getCells()[coordinate.getX()]
                [coordinate.getY()].getResidents();
        Set<? extends Organism> organisms = residents.get(this.getClass());
        return (organisms.size() <= this.getAmount());
    }

    private void move(GameField gameField) {
        Coordinate targetCoordinate = getDestination(getCurrentCoordinate(), this.getSpeed());
        if (checkDestination(targetCoordinate, gameField) && checkPopulationOnCell(gameField, targetCoordinate)) {
            Map<Type, Set<Organism>> residentsOfTargetCell = gameField.getCells()[targetCoordinate.getX()][targetCoordinate.getY()].getResidents();
            Set<Organism> organisms = residentsOfTargetCell.get(this.getClass());
            organisms.add(this);
            Map<Type, Set<Organism>> residentsOfCurrentCell = gameField.getCells()[getCurrentCoordinate().getX()][getCurrentCoordinate().getY()].getResidents();
            Set<Organism> organisms1 = residentsOfCurrentCell.get(this.getClass());
            Set<Organism> collect = organisms1.stream()
                    .filter(c -> !c.equals(this))
                    .collect(Collectors.toSet());
            organisms1=collect;

            System.out.println(this.getClass().getSimpleName() + " " + "moved to "+ targetCoordinate.getX()+" "+targetCoordinate.getY());
        }
    }

    private boolean checkDestination(Coordinate target, GameField gameField) {
        return (target.getX() > 0 && target.getX() < gameField.getWidth()
                && target.getY() > 0 && target.getY() < gameField.getHeight());
    }

    @Override
    public void play(GameField gameField) {
        this.eat(gameField);
        this.reproduceOnCell(gameField);
        this.move(gameField);
    }

    private Coordinate getDestination(Coordinate current, int max) {
        Direction direction = getDirection();
        return (new Coordinate(current.getX() + direction.getDeltaX() * getSteps(max),
                current.getY() + direction.getDeltaY() * getSteps(max)));
    }

    private Direction getDirection() {
        int number = (int) (Math.random() * 3 + 1);
        return switch (number) {
            case 1 -> Direction.LEFT;
            case 2 -> Direction.UP;
            case 3 -> Direction.DOWN;
            default -> Direction.RIGHT;
        };
    }

    private int getSteps(int max) {
        return (int) (Math.random() * max + 1);
    }

    private void eat(GameField gameField) {
        Map<Type, Set<Organism>> residents = gameField.getCells()[getCurrentCoordinate().getX()][getCurrentCoordinate().getY()].getResidents();
        Class<? extends Organism> target = chooseTarget();
        Set<Organism> organisms = residents.get(target);
        if (organisms.size() != 0) {
            Organism removedOrganism = null;
            for (Organism org : organisms) {
                removedOrganism = org;
            }
            if (removedOrganism != null) {
                this.setWeight(getWeight() + removedOrganism.getWeight());
                System.out.println(this.getClass().getSimpleName() + " " + "eat"+ " "+ removedOrganism.getClass().getSimpleName());
            }
            organisms.remove(removedOrganism);
            diedAnimals++;

        }
        setWeight(getWeight() - getFood());
    }

    private Class<? extends Organism> chooseTarget() {
        Class<? extends Organism> defaultTarget = null;
        int number = (int) (Math.random() * 100 + 1);
        for (Class<? extends Organism> clazz : targetMatrix.keySet()) {
            defaultTarget = clazz;
            if (targetMatrix.get(clazz) >= number) {
                return clazz;
            }
        }
        return defaultTarget;
    }

    public static void die(GameField gameField) {
        for (int i = 0; i < gameField.getWidth(); i++) {
            for (int j = 0; j < gameField.getHeight(); j++) {
                Set<Type> types = gameField.getCells()[i][j].getResidents().keySet();
                for (Type type : types) {
                    Set<Organism> organisms = gameField.getCells()[i][j].getResidents().get(type);
                    organisms.removeIf(organism -> organism.getWeight() < organism.getNormalWeight());
                    diedAnimals++;
                }
            }
        }
        System.out.println(diedAnimals + " organisms died");
    }


}
