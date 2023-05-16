package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex class that implements the IPokedex interface.
 * <p>
 * author fv
 */
public class Pokedex implements IPokedex {

    /**
     * List of pokemons.
     */
    private final List<Pokemon> pokemons;

    /**
     * Pokemon factory.
     */
    private final IPokemonFactory pokemonFactory;

    /**
     * Pokemon metadata provider.
     */
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * Default constructor.
     */
    public Pokedex() {
        pokemons = new ArrayList<>();
        pokemonFactory = new PokemonFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    /**
     * Constructor with parameters.
     *
     * @param metadataProvider Pokemon metadata provider.
     * @param factory          Pokemon factory.
     */
    public Pokedex(final IPokemonMetadataProvider metadataProvider,
                   final IPokemonFactory factory) {
        pokemons = new ArrayList<>();
        pokemonFactory = factory;
        pokemonMetadataProvider = metadataProvider;
    }

    @Override
    public final int size() {
        return pokemons.size();
    }

    @Override
    public final int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    @Override
    public final Pokemon getPokemon(final int id) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Pokemon not found");
    }

    @Override
    public final List<Pokemon> getPokemons() {
        return List.copyOf(pokemons);
    }

    @Override
    public final List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return List.copyOf(sortedPokemons);
    }

    @Override
    public final Pokemon createPokemon(final int index, final int cp,
                                       final int hp,
                                       final int dust, final int candy)
            throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public final PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
