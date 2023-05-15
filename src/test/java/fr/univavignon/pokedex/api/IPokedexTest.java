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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {

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
        when(pokedexFactory.createPokedex(pokemonMetadataProvider,
                pokemonFactory)).thenReturn(pokedex);
        when(pokedex.size()).thenReturn(0);
        when(pokedex.addPokemon(BULBIZARRE)).thenReturn(1);
        when(pokedex.getPokemon(0)).thenReturn(BULBIZARRE);
        when(pokedex.getPokemons()).thenReturn(
                Collections.singletonList(BULBIZARRE));

        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(
                new PokemonMetadata(0, "Bulbizare", 126, 126, 90));
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(
                BULBIZARRE);
        when(BULBIZARRE.getIndex()).thenReturn(0);
        when(BULBIZARRE.getName()).thenReturn("Bulbizare");
        when(BULBIZARRE.getAttack()).thenReturn(126);
        when(BULBIZARRE.getDefense()).thenReturn(126);
        when(BULBIZARRE.getStamina()).thenReturn(90);


    }


    @After
    /**
     * Delete the instance of the class Pokedex
     */
    public void tearDown() {
        pokedex = null;
    }

    @Test
    /**
     * Test the method size() of the class Pokedex
     */
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    /**
     * Test the method addPokemon(Pokemon pokemon) of the class Pokedex
     */
    public void testAddPokemon() {
        assertEquals(1, pokedex.addPokemon(BULBIZARRE));
    }

    @Test
    /**
     * Test the method getPokemon(int index) of the class Pokedex
     */
    public void testGetPokemon() throws PokedexException {
        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(BULBIZARRE);
        assertEquals(BULBIZARRE, pokedex.getPokemon(0));
    }

    @Test
    /**
     * Test the method getPokemon(int index) of the class Pokedex with the exception PokedexException
     */
    public void testGetPokemonWithException() throws PokedexException {
        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(BULBIZARRE);
        Assert.assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(1);
        });
    }

    @Test
    /**
     * Test the method getPokemons() of the class Pokedex
     */
    public void testGetPokemons() {
        Pokedex pokedex = new Pokedex();
        Comparator<Pokemon> comparator = new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon o1, Pokemon o2) {
                return o1.getIndex() - o2.getIndex();
            }
        };
        final List<Pokemon> pokemons = new ArrayList<Pokemon>();
        assertEquals(pokemons, pokedex.getPokemons(comparator));
    }

    @Test
    /**
     * Test the instanciation of the private attribute pokemonFactory
     */
    public void testPokemonFactoryInstantiation() throws Exception {
        Pokedex pokedex = new Pokedex();

        Field pokemonFactory =
                pokedex.getClass().getDeclaredField("pokemonFactory");
        pokemonFactory.setAccessible(true);
        assertNotNull(pokemonFactory.get(pokedex));
    }

    @Test
    /**
     * Test the instanciation of the private attribute pokemonMetadataProvider
     */
    public void testPokemonMetadataProviderInstantiation() throws Exception {
        Pokedex pokedex = new Pokedex();

        Field pokemonMetadataProvider =
                pokedex.getClass().getDeclaredField("pokemonMetadataProvider");
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
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(
                pokemon);
        assertEquals(0, pokedex.addPokemon(pokemon));
    }

    @Test
    /**
     * Test the setPokemons method
     */
    public void testSetPokemons() throws Exception {
        Pokedex pokedex = new Pokedex();
        List<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokedex.setPokemons(pokemons);
        assertEquals(pokemons, pokedex.getPokemons());
    }

    @Test
    /**
     * Test the createPokemon method
     */
    public void testCreatePokemon() throws Exception {
        Pokedex pokedex = new Pokedex();
        Pokemon pokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);
        Pokemon pokemonMock = mock(Pokemon.class);
        when(pokemonMock.getIndex()).thenReturn(0);
        when(pokemonMock.getCp()).thenReturn(613);
        when(pokemonMock.getHp()).thenReturn(64);
        when(pokemonMock.getDust()).thenReturn(4000);
        when(pokemonMock.getCandy()).thenReturn(4);
        assertEquals(pokemonMock.getIndex(), pokemon.getIndex());
        assertEquals(pokemonMock.getCp(), pokemon.getCp());
        assertEquals(pokemonMock.getHp(), pokemon.getHp());
        assertEquals(pokemonMock.getDust(), pokemon.getDust());
        assertEquals(pokemonMock.getCandy(), pokemon.getCandy());
    }

    @Test
    /**
     * Test the getPokemonMetadata method
     */
    public void testGetPokemonMetadata() throws Exception {
        Pokemon pokemon = new Pokemon(0, "Bulbizare", 126, 126, 90, 613, 64,
                4000, 4, 0.56);
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        pokedex.addPokemon(pokemon);
        PokemonMetadata pokemonMetadata = pokedex
                .getPokemonMetadata(0);
        assertEquals(pokemonMetadata.getIndex(), pokemon.getIndex());
        assertEquals(pokemonMetadata.getAttack(), pokemon.getAttack());
        assertEquals(pokemonMetadata.getDefense(), pokemon.getDefense());
        assertEquals(pokemonMetadata.getStamina(), pokemon.getStamina());

    }


}