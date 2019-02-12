package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badgesCount = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badgesCount = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getBadgesCount() {
        return this.badgesCount;
    }

    public int getPokemonsCount() {
        return this.pokemons.size();
    }

    void add(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    void processElement(String element) {
        if (isPokemon(element)) {
            this.badgesCount++;
        } else {
            pokemons.forEach(Pokemon::reduceHealth);
            this.pokemons = this.pokemons.stream()
                    .filter(Pokemon::isAlive)
                    .collect(Collectors.toCollection(ArrayList::new));

        }
    }

    private boolean isPokemon(String element) {
        return this.pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }
    public int compareTo(Trainer other){
        return Integer.compare(other.badgesCount,this.badgesCount);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",this.getName(),this.getBadgesCount(),this.getPokemonsCount());
    }
}
