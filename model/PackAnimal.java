package model;

import java.time.LocalDate;

public abstract class PackAnimal extends Animal {
    public PackAnimal(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }
}
