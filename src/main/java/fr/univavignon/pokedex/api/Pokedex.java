package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    /**
     * List of all pokemons this pokedex contains.
     */
    private List<Pokemon> pokemons;

    /**
     * Pokemon factory instance used to create pokemon.
     */
    private IPokemonFactory pokemonFactory = new PokemonFactory();

    /**
     * Pokemon metadata provider instance used to retrieve pokemon metadata.
     */
    private IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();

    /**
     * Default constructor.
     */
    public Pokedex() {
        pokemons = new ArrayList<Pokemon>();
    }

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = metadataProvider;
        pokemons = new ArrayList<Pokemon>();
    }


    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Getter for the factory instance.
     */
    public IPokemonFactory getPokemonFactory() {
        return pokemonFactory;
    }

    /**
     * Setter for the factory instance.
     */
    public void setPokemonFactory(IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Getter for the metadata provider instance.
     */
    public IPokemonMetadataProvider getPokemonMetadataProvider() {
        return pokemonMetadataProvider;
    }

    /**
     * Setter for the metadata provider instance.
     */
    public void setPokemonMetadataProvider(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }



    /**
     * Adds the given pokemon to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.indexOf(pokemon);
    }


    /**
     * Locates the pokemon identified by the given id.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Pokemon not found");
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        final List<Pokemon> unmodifiableList = new ArrayList<>(pokemons);
        return unmodifiableList;
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given order.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        final List<Pokemon> unmodifiableList = new ArrayList<>(pokemons);
        unmodifiableList.sort(order);
        return unmodifiableList;
    }

    /**
     * Setter for the pokemons list
     */
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given index.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}