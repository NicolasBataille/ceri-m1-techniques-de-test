package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokedexFactoryTest {

    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    IPokedexFactory pokedexFactory;

    IPokedex pokedex;

    @Before
    public void setUp() throws Exception {

        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);

        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(pokemonMetadataProvider,
                pokemonFactory)).thenReturn(pokedex);
    }


    @Test
    public void testCreatePokedex() {
        assertNotNull(pokedex);
    }

    @Test
    public void testPokedexConstructor() {
        assertNotNull(pokedexFactory.createPokedex(pokemonMetadataProvider,
                pokemonFactory));
    }
}