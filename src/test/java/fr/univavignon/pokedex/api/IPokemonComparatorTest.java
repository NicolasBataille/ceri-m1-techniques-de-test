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

        Assert.assertEquals(bulbizarre.getName(), pokemons.get(0).getName());
        Assert.assertEquals(dracaufeu.getName(), pokemons.get(1).getName());
        Assert.assertEquals(pikachu.getName(), pokemons.get(2).getName());
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

        Assert.assertEquals(bulbizarre.getName(), pokemons.get(0).getName());
        Assert.assertEquals(dracaufeu.getName(), pokemons.get(1).getName());
        Assert.assertEquals(pikachu.getName(), pokemons.get(2).getName());
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

        Assert.assertEquals(bulbizarre.getName(), pokemons.get(0).getName());
        Assert.assertEquals(dracaufeu.getName(), pokemons.get(1).getName());
        Assert.assertEquals(pikachu.getName(), pokemons.get(2).getName());
    }
}

