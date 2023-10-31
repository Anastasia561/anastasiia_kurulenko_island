package ua.javarush.island.configurator;

import ua.javarush.island.annotations.Config;
import ua.javarush.island.annotations.GameObjectEntity;
import ua.javarush.island.field.Cell;
import ua.javarush.island.field.Coordinate;
import ua.javarush.island.field.GameField;
import ua.javarush.island.organism.Organism;
import ua.javarush.island.organism.animal.predator.Wolf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AppConfigurator {

    private static AppConfigurator instance;

    private GameField gameField;

    private static GameObjectScanner gameObjectScanner = GameObjectScanner.getInstance();

    private static GameObjectLoader gameObjectLoader = GameObjectLoader.getInstance();

    private static OrganismFactory organismFactory = OrganismFactory.getInstance();


    private AppConfigurator(){
    }

    public static AppConfigurator getInstance(){
        if(instance==null){
            instance=new AppConfigurator();
        }
        return instance;
    }

    public void init(){
        registerPrototypes();
        createGameField(3, 2);
        placeOrganisms();
        count();

    }

    public void registerPrototypes(){
        gameObjectScanner.getGameObjectClasses()
                .stream()
                .map(gameObjectLoader::loadPrototype)
                .forEach(organismFactory::registerPrototype);

    }

    private void createGameField(int width, int height){
        Cell[][] cells = new Cell[width][height];
        gameField = new GameField(width, height, cells);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(new Coordinate(i, j));
            }
        }
    }

    private void placeOrganisms(){
        Set<Class<? extends Organism>> gameObjectClasses = gameObjectScanner.getGameObjectClasses();
        for (int i = 0; i < gameField.getWidth() ; i++) {
            for (int j = 0; j < gameField.getHeight() ; j++) {
                for (Class<? extends Organism> clazz:gameObjectClasses) {
                    gameField.getCells()[i][j].getResidents().put(clazz, generateRandomAmount(clazz));
                }
            }
        }

    }

    private Set<Organism> generateRandomAmount(Class<? extends Organism> clazz){
        Set<Organism> organisms = new HashSet<>();
        Set<Class<? extends Organism>> gameObjectClasses = gameObjectScanner.getGameObjectClasses();
            int amount = gameObjectLoader.loadPrototype(clazz).getAmount();
            int randomNumber = (int)(Math.random()*amount+1);
            for (int i = 0; i < randomNumber; i++) {
                organisms.add(organismFactory.create(clazz));
            }

        return organisms;
    }

    private void  count(){
        Set<Class<? extends Organism>> gameObjectClasses = gameObjectScanner.getGameObjectClasses();
            for (int i = 0; i < gameField.getWidth(); i++) {
                for (int j = 0; j < gameField.getHeight(); j++) {
                    for (Class<? extends Organism> clazz : gameObjectClasses) {
                        int size = gameField.getCells()[i][j].getResidents().get(clazz).size();
                        System.out.println(clazz.getSimpleName() + size);

                    }

                }
            }
        }
    }


