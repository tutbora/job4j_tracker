package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        String nameModel = "A320";
        final Airbus airbus = new Airbus(nameModel);
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine(nameModel);

        nameModel = "A380";
        airbus.setName(nameModel);
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine(nameModel);
    }
}