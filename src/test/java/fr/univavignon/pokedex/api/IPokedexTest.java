package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.junit.BeforeEach;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

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

//    @BeforeEach
//    public void setUpEach() throws Exception {
//        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
//        pokemonFactory = mock(IPokemonFactory.class);
//        pokedexFactory = mock(IPokedexFactory.class);
//
//        BULBIZARRE = mock(Pokemon.class);
//        pokedex = mock(IPokedex.class);
//        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
//        when(pokedex.size()).thenReturn(0);
//        when(pokedex.addPokemon(BULBIZARRE)).thenReturn(1);
//        when(pokedex.getPokemon(0)).thenReturn(BULBIZARRE);
//        when(pokedex.getPokemons()).thenReturn(Collections.singletonList(BULBIZARRE));
//    }




    @After
    public void tearDown(){
        pokedex = null;
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemon(){
        assertEquals(1, pokedex.addPokemon(BULBIZARRE));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(BULBIZARRE, pokedex.getPokemon(0));
    }

    @Test
    public void testGetPokemons() {
        assertEquals(Collections.singletonList(BULBIZARRE), pokedex.getPokemons());
    }

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

    @Test
    /**
     * Test the Size method with a mock
     */
    public void testSizeWithMock() throws PokedexException {
        Pokedex pokedex = new Pokedex();
        assertEquals(0, pokedex.size());
    }

    @Test
    /**
     * Test the pokedex constructor with arguments
     */
    public void testPokedexConstructor() {
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }

    @Test
    /**
     * Test the getPokemonFactory method
     */
    public void testGetPokemonFactory() throws Exception {
        Pokedex pokedex = new Pokedex();
        assertNotNull(pokedex.getPokemonFactory());
    }

    @Test
    /**
     * Test the setPokemonFactory method
     */
    public void testSetPokemonFactory() throws Exception {
        Pokedex pokedex = new Pokedex();
        pokedex.setPokemonFactory(pokemonFactory);
        assertNotNull(pokedex.getPokemonFactory());
    }

    @Test
    /**
     * Test the getPokemonMetadataProvider method
     */
    public void testGetPokemonMetadataProvider() throws Exception {
        Pokedex pokedex = new Pokedex();
        assertNotNull(pokedex.getPokemonMetadataProvider());
    }

    @Test
    /**
     * Test the setPokemonMetadataProvider method
     */
    public void testSetPokemonMetadataProvider() throws Exception {
        Pokedex pokedex = new Pokedex();
        pokedex.setPokemonMetadataProvider(pokemonMetadataProvider);
        assertNotNull(pokedex.getPokemonMetadataProvider());
    }

    @Test
    /**
     * Test the addPokemon method
     */
    public void testAddPokemonWithMock() throws Exception {
        Pokedex pokedex = new Pokedex();
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getIndex()).thenReturn(0);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
        assertEquals(1, pokedex.addPokemon(pokemon));
    }




}