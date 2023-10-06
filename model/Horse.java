package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    @Override
    public String toString() {
        return String.format("Horse\t%s\t%s",
                        this.getName(),
                        this.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
