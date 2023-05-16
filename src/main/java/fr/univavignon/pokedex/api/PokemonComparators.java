package fr.univavignon.pokedex.api;

import java.util.Comparator;

/**
 * Enumeration of pokemon comparator.
 *
 * @author fv
 */
public enum PokemonComparators implements Comparator<Pokemon> {

    /**
     * Comparator using Pokemon name.
     **/
    NAME(Comparator.comparing(Pokemon::getName)),

    /**
     * Comparator using Pokemon index.
     **/
    INDEX(Comparator.comparing(Pokemon::getIndex)),

    /**
     * Comparator using Pokemon combat point.
     **/
    CP(Comparator.comparing(Pokemon::getCp));

    /**
     * Delegate comparator instance.
     **/
    private final Comparator<Pokemon> pokemonComparator;

    /**
     * Default constructor.
     *
     * @param comparator Delegate comparator instance.
     */
    PokemonComparators(final Comparator<Pokemon> comparator) {
        this.pokemonComparator = comparator;
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public int compare(final Pokemon first, final Pokemon second) {
        return pokemonComparator.compare(first, second);
    }

}
