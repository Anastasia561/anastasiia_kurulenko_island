package ua.javarush.island.runner;

import ua.javarush.island.field.Cell;
import ua.javarush.island.field.Coordinate;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;
import ua.javarush.island.organism.animal.herbivorous.Caterpillar;
import ua.javarush.island.organism.animal.herbivorous.Duck;
import ua.javarush.island.organism.animal.herbivorous.Horse;
import ua.javarush.island.organism.animal.predator.Wolf;
import ua.javarush.island.organism.plant.Grass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Runner {
//    private final int width;
//    private final int height;
//    private static GameField gameField;
//
//    public static GameField getGameField() {
//        return gameField;
//    }
//
//    public Runner(int width, int height) {
//        this.width = width;
//        this.height = height;
//    }
//
//    public void startGame() {
//        createField();
//        placeOrganisms();
//        count();
//    }
//
//    private void createField() {
//        Cell[][] cells = new Cell[width][height];
//        gameField = new GameField(3, 2, cells);
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                cells[i][j] = new Cell(new Coordinate(i, j));
//            }
//        }
//
//    }
//
//    private void placeOrganisms() {
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                for (Class clazz : organisms) {
//                    gameField.getCells()[i][j].getResidents().put(clazz, generateOrganisms(clazz, 5));
//                }
//
//            }
//        }
//    }
//
//    private <T> Set<T> generateOrganisms(Class<T> clazz, int number) {
//        HashSet<T> set = new HashSet<>();
//        for (int i = 0; i < number; i++) {
//            set.add();
//        }
//        return set;
//    }

//    private void count() {
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                for (Class clazz : organisms) {
//                    int size = gameField.getCells()[i][j].getResidents().get(clazz).size();
//                    System.out.println(clazz.getSimpleName() + size);
//
//                }
//
//            }
//        }
//    }


}
