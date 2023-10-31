package ua.javarush.island.movingService;

import ua.javarush.island.field.Coordinate;
import ua.javarush.island.field.Direction;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;
import ua.javarush.island.organism.animal.Animal;
import ua.javarush.island.runner.Runner;

import java.util.Set;

public class MovingService {
    //GameField gameField = Runner.getGameField();

//    public void move(Coordinate current, int max, GameField gameField, Animal animal) {
//        if (!((current.getX() + getDestination(current, max).getX()) < 0) &&
//                !((current.getX() + getDestination(current, max).getX()) > gameField.getWidth())) {
//            Set<? extends Organism> organismsOfCurrentCell = gameField.getCells()[current.getX()][current.getY()].getResidents().get(animal.getClass());
//            organismsOfCurrentCell.remove(animal);
//
//            Set<? extends Organism> organismsOfNextCell = gameField.getCells()[current.getX()+getDestination(current, max).getX()]
//                                                                            [current.getY()+getDestination(current, max).getY()]
//                    .getResidents().get(animal.getClass());
//            organismsOfNextCell.add(animal);
//
//        }
//    }

    private Coordinate getDestination(Coordinate current, int max) {
        Direction direction = getDirection();
        Coordinate newCoordinate = new Coordinate(current.getX() + direction.getDeltaX() * getSteps(max),
                current.getY() + direction.getDeltaY() * getSteps(max));

        return newCoordinate;
    }

    private Direction getDirection() {
        int number = (int) (Math.random() * 3 + 1);
        Direction direction = switch (number) {
            case 1 -> Direction.LEFT;
            case 2 -> Direction.UP;
            case 3 -> Direction.DOWN;
            default -> Direction.RIGHT;
        };
        return direction;
    }

    private int getSteps(int max) {
        return (int) (Math.random() * max + 1);
    }

    public boolean checkPair(GameField gameField,Coordinate current, Organism org){
        int size = gameField.getCells()[current.getX()][current.getY()].getResidents().get(org.getClass()).size();
        return(size > 0);
    }
}
