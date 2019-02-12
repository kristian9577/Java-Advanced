package PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    void reduceHealth() {
        this.health -= 10;
    }

    public boolean isAlive() {
        return this.health > 10;
    }
}
