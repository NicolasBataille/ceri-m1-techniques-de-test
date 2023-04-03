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

public class IPokedexTest{

    IPokedex pokedex;
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    IPokedexFactory pokedexFactory;
    Pokemon BULBIZARRE;

    @Before
    public void setUp() throws Exception {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);

        BULBIZARRE = mock(Pokemon.class);
        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
        when(pokedex.size()).thenReturn(0);
        when(pokedex.addPokemon(BULBIZARRE)).thenReturn(1);
        when(pokedex.getPokemon(0)).thenReturn(BULBIZARRE);
        when(pokedex.getPokemons()).thenReturn(Collections.singletonList(BULBIZARRE));

    }

    @BeforeEach
    public void setUpEach() throws Exception {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);

        BULBIZARRE = mock(Pokemon.class);
        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
        when(pokedex.size()).thenReturn(0);
        when(pokedex.addPokemon(BULBIZARRE)).thenReturn(1);
        when(pokedex.getPokemon(0)).thenReturn(BULBIZARRE);
        when(pokedex.getPokemons()).thenReturn(Collections.singletonList(BULBIZARRE));
    }


    @After
    public void tearDown(){
        pokedex = null;
    }

    @Test
    public void testSize() {
        Assert.assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemon(){
        Assert.assertEquals(1, pokedex.addPokemon(BULBIZARRE));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Assert.assertEquals(BULBIZARRE, pokedex.getPokemon(0));
    }

    @Test
    public void testGetPokemons() {
        Assert.assertEquals(Collections.singletonList(BULBIZARRE), pokedex.getPokemons());
    }

}