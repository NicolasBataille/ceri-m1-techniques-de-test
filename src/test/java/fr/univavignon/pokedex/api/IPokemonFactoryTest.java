package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private static final int AQUALI_INDEX = 0;
    private static final int AQUALI_CP = 613;
    private static final int AQUALI_HP = 64;
    private static final int AQUALI_DUST = 4000;
    private static final int AQUALI_CANDY = 4;
    private static final double AQUALI_IV = 0.56;

    private Pokemon AQUALI;

    private PokemonFactory pokemonFactory;

    @Before
    /**
     * Create a AQUALI pokemon
     */
    public void setUp() throws PokedexException {
        pokemonFactory = new PokemonFactory();
        AQUALI = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4,100);
    }

    @Test
    /**
     * Test the createPokemon method
     */
    public void testCreatePokemon() throws PokedexException {
        Pokemon bulbiBis = pokemonFactory.createPokemon(AQUALI.getIndex(), AQUALI.getCp(), AQUALI.getHp(), AQUALI.getDust(), AQUALI.getCandy());
        assertEquals(AQUALI.getIndex(), bulbiBis.getIndex());
        assertEquals(AQUALI.getName(), bulbiBis.getName());
        assertEquals(AQUALI.getAttack(), bulbiBis.getAttack());
        assertEquals(AQUALI.getDefense(), bulbiBis.getDefense());
        assertEquals(AQUALI.getStamina(), bulbiBis.getStamina());
        assertEquals(AQUALI.getCp(), bulbiBis.getCp());
        assertEquals(AQUALI.getHp(), bulbiBis.getHp());
        assertEquals(AQUALI.getDust(), bulbiBis.getDust());
        assertEquals(AQUALI.getCandy(), bulbiBis.getCandy());
        assertEquals(AQUALI.getIv(), bulbiBis.getIv(), 0.001);
    }


}
