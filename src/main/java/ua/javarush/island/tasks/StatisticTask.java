package ua.javarush.island.tasks;

import ua.javarush.island.statistics.StatisticalProcessor;

public class StatisticTask implements Runnable{
    @Override
    public void run() {
        StatisticalProcessor.getInstance().getStatistics();
    }
}
