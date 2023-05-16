package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private static final int BULBIZARRE_INDEX = 0;
    private static final int BULBIZARRE_CP = 613;
    private static final int BULBIZARRE_HP = 64;
    private static final int BULBIZARRE_DUST = 4000;
    private static final int BULBIZARRE_CANDY = 4;
    private static final double BULBIZARRE_IV = 0.56;

    private Pokemon BULBIZARRE;

    private PokemonFactory pokemonFactory;

    @Before
    /**
     * Create a Bulbizarre pokemon
     */
    public void setUp() throws PokedexException {
        pokemonFactory = new PokemonFactory();
        BULBIZARRE = new Pokemon(133, "Bulbizarre", 186, 168, 260, 2729, 202, 5000, 4,100);
    }

    @Test
    /**
     * Test the createPokemon method
     */
    public void testCreatePokemon() throws PokedexException {
        Pokemon bulbiBis = pokemonFactory.createPokemon(BULBIZARRE.getIndex(), BULBIZARRE.getCp(), BULBIZARRE.getHp(), BULBIZARRE.getDust(), BULBIZARRE.getCandy());
        assertEquals(BULBIZARRE.getIndex(), bulbiBis.getIndex());
        assertEquals(BULBIZARRE.getName(), bulbiBis.getName());
        assertEquals(BULBIZARRE.getAttack(), bulbiBis.getAttack());
        assertEquals(BULBIZARRE.getDefense(), bulbiBis.getDefense());
        assertEquals(BULBIZARRE.getStamina(), bulbiBis.getStamina());
        assertEquals(BULBIZARRE.getCp(), bulbiBis.getCp());
        assertEquals(BULBIZARRE.getHp(), bulbiBis.getHp());
        assertEquals(BULBIZARRE.getDust(), bulbiBis.getDust());
        assertEquals(BULBIZARRE.getCandy(), bulbiBis.getCandy());
        assertEquals(BULBIZARRE.getIv(), bulbiBis.getIv(), 0.001);
    }


}
