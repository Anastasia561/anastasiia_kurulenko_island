package ua.javarush.island;

import ua.javarush.island.configurator.AppConfigurator;
import ua.javarush.island.runner.Runner;


public class Main {
    public static void main(String[] args) {
//        Runner runner = new Runner(3,2);
//        runner.startGame();
        AppConfigurator.getInstance().init();


    }

}