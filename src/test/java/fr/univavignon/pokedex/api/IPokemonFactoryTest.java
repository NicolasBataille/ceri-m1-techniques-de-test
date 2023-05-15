package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
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

        private IPokemonFactory pokemonFactory;

        @Before
        public void setUp() throws PokedexException {
            BULBIZARRE = new Pokemon(BULBIZARRE_INDEX, "Bulbizarre", 126, 126, 90, BULBIZARRE_CP, BULBIZARRE_HP, BULBIZARRE_DUST, BULBIZARRE_CANDY, 0.56);

            pokemonFactory = mock(IPokemonFactory.class);
            when(pokemonFactory.createPokemon(BULBIZARRE_INDEX, BULBIZARRE_CP, BULBIZARRE_HP, BULBIZARRE_DUST, BULBIZARRE_CANDY)).thenReturn(BULBIZARRE);
        }

        @Test
        public void testCreatePokemon() throws PokedexException {
            Pokemon pokemon = pokemonFactory.createPokemon(BULBIZARRE_INDEX, BULBIZARRE_CP, BULBIZARRE_HP, BULBIZARRE_DUST, BULBIZARRE_CANDY);
            assertEquals(BULBIZARRE_INDEX, pokemon.getIndex());
            assertEquals(BULBIZARRE_CP, pokemon.getCp());
            assertEquals(BULBIZARRE_HP, pokemon.getHp());
            assertEquals(BULBIZARRE_DUST, pokemon.getDust());
            assertEquals(BULBIZARRE_CANDY, pokemon.getCandy());
            assertEquals(BULBIZARRE_IV, pokemon.getIv(), 0.001);
        }

}
