package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        PokemonMetadata pokemonMetadata =
                new PokemonMetadataProvider().getPokemonMetadata(index);
        return new Pokemon(index, pokemonMetadata.getName(),
                pokemonMetadata.getAttack(), pokemonMetadata.getDefense(),
                pokemonMetadata.getDefense(), cp, hp, dust, candy, 100);
    }


    //Code de la Team Rocket
//    private static Map<Integer, String> index2name;
//
//    static {
//        Map<Integer, String> aMap = new HashMap<Integer, String>();
//        aMap.put(-1, "Ash's Pikachu");
//        aMap.put(0, "MISSINGNO");
//        aMap.put(1, "Bulbasaur");
//        //TODO : Gotta map them all !
//        index2name = UnmodifiableMap.unmodifiableMap(aMap);
//    }
//
//    private static int generateRandomStat() {
//        int total = 0;
//        for (int i = 0; i < 1000000; i++) {
//            Random rn = new Random();
//            int r = rn.nextInt(2);
//            total = total + r;
//        }
//        return total / 10000;
//    }
//
//    @Override
//    public Pokemon createPokemon(int index, int cp, int hp, int dust,
//                                 int candy) {
//        String name;
//        if (!index2name.containsKey(index)) {
//            name = index2name.get(0);
//        } else {
//            name = index2name.get(index);
//        }
//        int attack;
//        int defense;
//        int stamina;
//        double iv;
//        if (index < 0) {
//            attack = 1000;
//            defense = 1000;
//            stamina = 1000;
//            iv = 0;
//        } else {
//            attack = PokemonFactory.generateRandomStat();
//            defense = PokemonFactory.generateRandomStat();
//            stamina = PokemonFactory.generateRandomStat();
//            iv = 1;
//        }
//        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust,
//                candy, iv);
//    }
}
