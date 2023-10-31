package ua.javarush.island.configurator;

import ua.javarush.island.organism.Organism;

import java.util.HashMap;
import java.util.Map;

public class OrganismFactory {
    private static OrganismFactory instance;

    private final Map<Class<? extends Organism>, Organism> prototypes = new HashMap<>();
    private OrganismFactory(){}

    public static OrganismFactory getInstance(){
        if(instance==null){
            instance=new OrganismFactory();
        }
        return instance;
    }

    public void registerPrototype(Organism prototype){
        prototypes.put(prototype.getClass(), prototype);
    }

    public Organism create(Class<? extends Organism> clazz){
        return prototypes.get(clazz).reproduce();
    }

}
