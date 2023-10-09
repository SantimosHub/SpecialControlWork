package model;

import java.time.LocalDate;
import java.util.ArrayList;

import presenter.Model;

public class AnimalModel implements Model {
    private ArrayList<Animal> animals = new ArrayList<>();

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public boolean addAnimal(String name, LocalDate dateOfBirth, AnimalType type) throws Exception {
        try (Counter counter = new Counter()) {
            counter.add(name, dateOfBirth, type);
            switch (type) {
            case CAT:
                return this.animals.add(new Cat(name, dateOfBirth));
            case DOG:
                return this.animals.add(new Dog(name, dateOfBirth));
            case HAMSTER:
                return this.animals.add(new Hamster(name, dateOfBirth));
            case HORSE:
                return this.animals.add(new Horse(name, dateOfBirth));
            case CAMEL:
                return this.animals.add(new Camel(name, dateOfBirth));
            case DONKEY:
                return this.animals.add(new Donkey(name, dateOfBirth));
            default:
                throw new IllegalArgumentException("The AnimalModel doesn't know such an animal.");
        }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean addCommand(int index, String command) {
        return this.animals.get(index).getCommands().add(command);
    }
}
