package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 *
 * author fv
 */
public class PokemonMetadata {

    /**
     * Pokemon index.
     */
    private final int pokemonIndex;

    /**
     * Pokemon name.
     */
    private final String pokemonName;

    /**
     * Pokemon attack level.
     */
    private final int pokemonAttack;

    /**
     * Pokemon defense level.
     */
    private final int pokemonDefense;

    /**
     * Pokemon stamina level.
     */
    private final int pokemonStamina;

    /**
     * Default constructor.
     *
     * @param index   Pokemon index.
     * @param name    Pokemon name.
     * @param attack  Attack level.
     * @param defense Defense level.
     * @param stamina Stamina level.
     */
    public PokemonMetadata(final int index, final String name, final int attack,
                           final int defense, final int stamina) {
        this.pokemonIndex = index;
        this.pokemonName = name;
        this.pokemonAttack = attack;
        this.pokemonDefense = defense;
        this.pokemonStamina = stamina;
    }

    /**
     * Index getter.
     *
     * @return the index of the pokemon
     */
    public int getIndex() {
        return pokemonIndex;
    }

    /**
     * Name getter.
     *
     * @return the name of the pokemon
     */
    public String getName() {
        return pokemonName;
    }

    /**
     * Attack level getter.
     *
     * @return the attack level of the pokemon
     */
    public int getAttack() {
        return pokemonAttack;
    }

    /**
     * Defense level getter.
     *
     * @return the defense level of the pokemon
     */
    public int getDefense() {
        return pokemonDefense;
    }

    /**
     * Stamina level getter.
     *
     * @return the stamina level of the pokemon
     */
    public int getStamina() {
        return pokemonStamina;
    }
}
