package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
public class IPokemonTrainerFactoryTest{


    IPokemonTrainerFactory pokemonTrainerFactory;

    IPokedex pokedex;

    IPokedexFactory pokedexFactory;

    @Before
    public void setUp() throws Exception {
        pokedexFactory = mock(IPokedexFactory.class);
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedex = mock(IPokedex.class);

        when(pokemonTrainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory)).thenReturn(new PokemonTrainer("Sacha", Team.MYSTIC, pokedex));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateTrainer() {
        assertNotNull(pokemonTrainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory));
    }
}