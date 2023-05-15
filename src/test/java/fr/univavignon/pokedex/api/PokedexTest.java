package fr.univavignon.pokedex.api;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;

public class PokedexTest {

    @Test
    /**
     * Test the instanciation of the private attribute pokemonFactory
     */
    public void testPokemonFactoryInstantiation() throws Exception {
        Pokedex pokedex = new Pokedex();

        Field pokemonFactory = pokedex.getClass().getDeclaredField("pokemonFactory");
        pokemonFactory.setAccessible(true);
        assertNotNull(pokemonFactory.get(pokedex));
    }

    @Test
    /**
     * Test the instanciation of the private attribute pokemonMetadataProvider
     */
    public void testPokemonMetadataProviderInstantiation() throws Exception {
        Pokedex pokedex = new Pokedex();

        Field pokemonMetadataProvider = pokedex.getClass().getDeclaredField("pokemonMetadataProvider");
        pokemonMetadataProvider.setAccessible(true);
        assertNotNull(pokemonMetadataProvider.get(pokedex));
    }
}
