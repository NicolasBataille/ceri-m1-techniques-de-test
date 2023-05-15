package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IPokemonMetadataProviderTest {

    private static final int BULBIZARRE_INDEX = 0;
    private static final String BULBIZARRE_NAME = "BULBIZARRE";
    private static final int BULBIZARRE_ATTACK = 126;
    private static final int BULBIZARRE_DEFENSE = 126;
    private static final int BULBIZARRE_STAMINA = 90;

    private PokemonMetadata BULBIZARREMetadata;

    private IPokemonMetadataProvider metadataProvider;

    @Before
    /**
     * Setup
     */
    public void setUp() throws PokedexException {
        BULBIZARREMetadata =
                new PokemonMetadata(BULBIZARRE_INDEX, BULBIZARRE_NAME,
                        BULBIZARRE_ATTACK, BULBIZARRE_DEFENSE,
                        BULBIZARRE_STAMINA);

        metadataProvider = mock(IPokemonMetadataProvider.class);
        when(metadataProvider.getPokemonMetadata(BULBIZARRE_INDEX)).thenReturn(
                BULBIZARREMetadata);
        when(metadataProvider.getPokemonMetadata(1000)).thenThrow(
                new PokedexException("L'index du pokémon n'existe pas"));

    }

    @Test
    /**
     * Test the method getPokemonMetadata
     */
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata =
                metadataProvider.getPokemonMetadata(BULBIZARRE_INDEX);

        assertEquals(BULBIZARRE_INDEX, metadata.getIndex());
        assertEquals(BULBIZARRE_NAME, metadata.getName());
        assertEquals(BULBIZARRE_ATTACK, metadata.getAttack());
        assertEquals(BULBIZARRE_DEFENSE, metadata.getDefense());
        assertEquals(BULBIZARRE_STAMINA, metadata.getStamina());
    }

    @After
    /**
     * Teardown
     */
    public void tearDown() {
        BULBIZARREMetadata = null;
        metadataProvider = null;
    }


    @Test
    /**
     * Test the method getPokemonMetadata throws PokedexException
     */
    public void testGetPokemonMetadataThrowsPokedexException()
            throws PokedexException {
        try {
            metadataProvider.getPokemonMetadata();
            Assert.fail("Expected an PokedexException to be thrown");
        } catch (PokedexException e) {
            Assert.assertEquals("L'index du pokémon n'existe pas",
                    e.getMessage());
        }
    }

}

