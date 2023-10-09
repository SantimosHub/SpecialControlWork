package presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import model.Animal;
import model.AnimalType;

public interface View {
    public void setObserver(ViewObserver observer);

    public void showMenu();

    public void showListOfAnimals(ArrayList<Animal> animals);

    public String getName() throws Exception;

    public LocalDate getDateOfBirth() throws Exception;

    public AnimalType getAnimalType() throws Exception;

    public void showError(Exception e);

    public int animalChoosing(ArrayList<Animal> animals) throws Exception;

    public void showCommands(HashSet<String> commands);

    public String enterCommand() throws Exception;
}
