package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import model.Animal;
import model.AnimalType;
import presenter.View;
import presenter.ViewObserver;

public class NurseryView implements View {
    private ViewObserver observer;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void showMenu() {
        System.out.println(
                "Enter the number of the action you'd like:\n1. Show all animals;\n2. Add animal;\n3. Show the list of commands;\n4. Add another command;\n0. Exit.");
        boolean isSelected = false;

        while (!isSelected) {
            try {
                int number = Integer.parseInt(scanner.nextLine());

                switch (number) {
                    case 1:
                        isSelected = true;
                        this.observer.onShowListOfAnimals();
                        break;
                    case 2:
                        isSelected = true;
                        this.observer.onAddAnimal();
                        break;
                    case 3:
                        isSelected = true;
                        this.observer.onShowTheListOfCommands();
                        break;
                    case 4:
                        isSelected = true;
                        this.observer.onAddCommands();
                        break;
                    case 0:
                        isSelected = true;
                        break;
                    default:
                        System.out.println("The number is incorrect. Try again.");
                }
            } catch (Exception e) {
                System.out.println("This is not a number. Try again.");
            }
        }
    }

    @Override
    public void showListOfAnimals(ArrayList<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("There aren't any animals.");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                System.out.printf("%d\t%s\n", i, animal);
            }
        }
    }

    @Override
    public String getName() throws Exception {
        System.out.println("Enter the animal's name:");
        try {
            String name = scanner.nextLine();
            return name;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public LocalDate getDateOfBirth() throws DateTimeParseException {
        System.out.println("Enter the animal's date of birth like \"30.12.2023\":");
        try {
            return LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public AnimalType getAnimalType() throws Exception {
        System.out.println(
                "Enter the animal's type:\n1. Cat;\n2. Dog;\n3. Hamster\n4. Horse\n5. Camel;\n6. Donkey\n0. Exit.");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    return AnimalType.CAT;
                case 2:
                    return AnimalType.DOG;
                case 3:
                    return AnimalType.HAMSTER;
                case 4:
                    return AnimalType.HORSE;
                case 5:
                    return AnimalType.CAMEL;
                case 6:
                    return AnimalType.DONKEY;
                default:
                    throw new IllegalArgumentException("The number is incorrect.");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void showError(Exception e) {
        System.out.println("Something went wrong." + e.getMessage());
    }

    @Override
    public int animalChoosing(ArrayList<Animal> animals) throws Exception {
        this.showListOfAnimals(animals);
        System.out.println("Enter the number of animal you choose:");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number >= 0 && number < animals.size()) {
                return number;
            } else {
                throw new IllegalArgumentException("There is no such an animal.");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void showCommands(HashSet<String> commands) {
        System.out.println(commands.toString());
    }

    @Override
    public String enterCommand() throws Exception {
        System.out.println("Enter the command you want to add:");
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            throw e;
        }
    }

}
