import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.AnimalModel;
import model.AnimalType;
import presenter.Model;
import presenter.NurseryPresenter;
import presenter.View;
import presenter.ViewObserver;
import view.NurseryView;

public class Program {

    public static void main(String[] args) {
        Model model = new AnimalModel();
        View view = new NurseryView();
        ViewObserver presenter = new NurseryPresenter(model, view);

        try {
            model.addAnimal(
                    "Vasya",
                    LocalDate.parse("12.06.2015", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    AnimalType.CAT);
            model.addAnimal(
                    "Murzik",
                    LocalDate.parse("20.06.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    AnimalType.CAT);
            model.addAnimal(
                    "Pushok",
                    LocalDate.parse("10.10.2022", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    AnimalType.CAT);
            model.addAnimal(
                    "Sharik",
                    LocalDate.parse("30.01.2017", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    AnimalType.DOG);
            model.addAnimal(
                    "Butsefal",
                    LocalDate.parse("17.07.2010", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    AnimalType.DONKEY);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        presenter.start();
    }
}
