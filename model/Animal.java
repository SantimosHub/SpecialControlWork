package model;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class Animal {
    private final String name;
    private final LocalDate dateOfBirth;
    private HashSet<String> commands;
    
    public Animal(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commands = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public HashSet<String> getCommands() {
        return this.commands;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }
}