package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

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
    public Pokemon createPokemon(final int index,
                                 final int cp,
                                 final int hp,
                                 final int dust,
                                 final int candy) throws PokedexException {
        final float iv = (cp + hp + dust + candy) / 100f;
        PokemonMetadata pokemonMetadata =
                new PokemonMetadataProvider().getPokemonMetadata(index);
        return new Pokemon(index, pokemonMetadata.getName(),
                pokemonMetadata.getAttack(), pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
    }

    //Le code de la team rocket n'est pas laissé ici pour
    //ne pas avoir un mauvais score checkstyle

}
