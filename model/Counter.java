package model;

import java.io.Closeable;
import java.time.LocalDate;

public class Counter implements Closeable {
    private static int count = 0;

    public void add(String name, LocalDate dateOfBirth, AnimalType type) throws Exception {
        if (name != null && dateOfBirth != null && type != null) {
            this.count += 1;
        } else {
            throw new NullPointerException("Some data is null.");
        }
    }

    @Override
    public void close() {
        System.out.println("The counter is closing...");
    }
}
