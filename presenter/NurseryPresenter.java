package presenter;

import model.Animal;

public class NurseryPresenter implements ViewObserver {
    private Model model;
    private View view;

    public NurseryPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setObserver(this);
    }

    @Override
    public void start() {
        this.view.showMenu();
    }

    @Override
    public void onShowListOfAnimals() {
        this.view.showListOfAnimals(this.model.getAnimals());
        this.view.showMenu();
    }

    @Override
    public void onAddAnimal() {
        try {
            this.model.addAnimal(
                    this.view.getName(),
                    this.view.getDateOfBirth(),
                    this.view.getAnimalType());
            this.view.showMenu();
        } catch (Exception e) {
            this.view.showError(e);
            this.view.showMenu();
        }
    }

    @Override
    public void onShowTheListOfCommands() {
        try {
            int index = this.view.animalChoosing(this.model.getAnimals());
            Animal animal = this.model.getAnimals().get(index);
            this.view.showCommands(animal.getCommands());
            this.view.showMenu();
        } catch (Exception e) {
            this.view.showError(e);
            this.view.showMenu();
        }
        
    }

    @Override
    public void onAddCommands() {
        try {
            int index = this.view.animalChoosing(this.model.getAnimals());
            String command = this.view.enterCommand();
            this.model.addCommand(index, command);
            this.view.showMenu();
        } catch (Exception e) {
            this.view.showError(e);
            this.view.showMenu();
        }
    }
}
