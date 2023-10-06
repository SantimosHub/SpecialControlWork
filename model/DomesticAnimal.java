package model;

import java.time.LocalDate;

public abstract class DomesticAnimal extends Animal {
    public DomesticAnimal(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }
}
