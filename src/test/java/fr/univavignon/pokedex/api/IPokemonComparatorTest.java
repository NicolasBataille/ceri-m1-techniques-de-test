package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPokemonComparatorTest {

    @Test
    public void testSortByName() {
        Pokemon pikachu = new Pokemon(0, "pikachu", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;
        Pokemon bulbizarre = new Pokemon(1, "Bulbizare", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;
        Pokemon dracaufeu = new Pokemon(2, "dracaufeu", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pikachu);
        pokemons.add(bulbizarre);
        pokemons.add(dracaufeu);

        Collections.sort(pokemons, PokemonComparators.NAME);

        Assert.assertEquals(bulbizarre, pokemons.get(0));
        Assert.assertEquals(dracaufeu, pokemons.get(1));
        Assert.assertEquals(pikachu, pokemons.get(2));
    }

    @Test
    public void testSortByIndex() {
        Pokemon pikachu = new Pokemon(0, "pikachu", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;
        Pokemon bulbizarre = new Pokemon(1, "Bulbizare", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;
        Pokemon dracaufeu = new Pokemon(2, "dracaufeu", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pikachu);
        pokemons.add(bulbizarre);
        pokemons.add(dracaufeu);

        Collections.sort(pokemons, PokemonComparators.INDEX);

        Assert.assertEquals(bulbizarre, pokemons.get(0));
        Assert.assertEquals(dracaufeu, pokemons.get(1));
        Assert.assertEquals(pikachu, pokemons.get(2));
    }

    @Test
    public void testSortByCP() {
        Pokemon pikachu = new Pokemon(0, "pikachu", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;
        Pokemon bulbizarre = new Pokemon(1, "Bulbizare", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;
        Pokemon dracaufeu = new Pokemon(2, "dracaufeu", 126, 126,
                90, 613, 64, 4000, 4,
                0.56);
        ;

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pikachu);
        pokemons.add(bulbizarre);
        pokemons.add(dracaufeu);

        Collections.sort(pokemons, PokemonComparators.CP);

        Assert.assertEquals(pikachu, pokemons.get(0));
        Assert.assertEquals(bulbizarre, pokemons.get(1));
        Assert.assertEquals(dracaufeu, pokemons.get(2));
    }
}

