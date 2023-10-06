package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Camel extends PackAnimal {
    public Camel(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    } 

    @Override
    public String toString() {
        return String.format("Camel\t%s\t%s",
                        this.getName(),
                        this.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
