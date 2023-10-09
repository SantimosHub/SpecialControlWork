package presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Animal;
import model.AnimalType;

public interface Model {
    public ArrayList<Animal> getAnimals();

    public boolean addAnimal(String name, LocalDate dateOfBirth, AnimalType type) throws Exception;

    public boolean addCommand(int index, String command);
}
