package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable  {
    private String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    public void startCookingOrder(Order order) {

        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString()
                + ", cooking time " + order.getTotalCookingTime() + "min");
        try {
            Thread.sleep(10 * order.getTotalCookingTime());
        }catch (InterruptedException ex) {}

        setChanged();
        notifyObservers(order);

        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(order.getTablet().toString(),
                        this.toString(), order.getTotalCookingTime() * 60, order.getDishes()));

        busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }
}
