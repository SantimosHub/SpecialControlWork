package presenter;

public interface ViewObserver {
    public void start();

    public void onShowListOfAnimals();

    public void onAddAnimal();

    public void onShowTheListOfCommands();

    public void onAddCommands();
}
