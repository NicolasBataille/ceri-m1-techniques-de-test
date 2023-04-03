package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private static final int BULBIZARRE_INDEX = 0;
    private static final String BULBIZARRE_NAME = "BULBIZARRE";
    private static final int BULBIZARRE_ATTACK = 126;
    private static final int BULBIZARRE_DEFENSE = 126;
    private static final int BULBIZARRE_STAMINA = 90;

    private PokemonMetadata BULBIZARREMetadata;

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() throws PokedexException {
        BULBIZARREMetadata = new PokemonMetadata(BULBIZARRE_INDEX, BULBIZARRE_NAME, BULBIZARRE_ATTACK, BULBIZARRE_DEFENSE, BULBIZARRE_STAMINA);

        metadataProvider = mock(IPokemonMetadataProvider.class);
        when(metadataProvider.getPokemonMetadata(BULBIZARRE_INDEX)).thenReturn(BULBIZARREMetadata);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(BULBIZARRE_INDEX);
        assertEquals(BULBIZARRE_INDEX, metadata.getIndex());
        assertEquals(BULBIZARRE_NAME, metadata.getName());
        assertEquals(BULBIZARRE_ATTACK, metadata.getAttack());
        assertEquals(BULBIZARRE_DEFENSE, metadata.getDefense());
        assertEquals(BULBIZARRE_STAMINA, metadata.getStamina());
    }

    @After
    public void tearDown() {
        BULBIZARREMetadata = null;
        metadataProvider = null;
    }
}

