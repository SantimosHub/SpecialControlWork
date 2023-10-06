package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cat extends DomesticAnimal {
    public Cat(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    @Override
    public String toString() {
        return String.format("Cat\t%s\t%s",
                        this.getName(),
                        this.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
