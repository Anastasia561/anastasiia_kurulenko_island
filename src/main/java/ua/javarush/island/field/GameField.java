package ua.javarush.island.field;

import lombok.Getter;

public class GameField {
    @Getter
    private final int width;
    @Getter
    private final int height;
    @Getter
    private Cell[][] cells;


    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void createCells() {
        Cell[][] cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(new Coordinate(i, j));
            }
        }
        this.cells = cells;
    }

}
