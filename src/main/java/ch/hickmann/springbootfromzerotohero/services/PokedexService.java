package ch.hickmann.springbootfromzerotohero.services;

import ch.hickmann.springbootfromzerotohero.entities.Pokemon;
import ch.hickmann.springbootfromzerotohero.repositories.PokemonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokedexService {
    private final PokemonRepository pokemonRepository;

    public PokedexService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon savePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public List<Pokemon> findAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Pokemon findPokemonById(Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if (pokemon.isPresent())
            return pokemon.get();
        else
            return null;
    }

    public Pokemon updatePokemon(Long id, Pokemon pokemon) {
        Optional<Pokemon> pokemonSaved = pokemonRepository.findById(id);
        if (pokemonSaved.isPresent()) {
            Pokemon pokemonAux = pokemonSaved.get();
            pokemonAux.setName(pokemon.getName());
            pokemonAux.setNationalNumber(pokemon.getNationalNumber());
            pokemonAux.setType(pokemon.getType());

            return pokemonRepository.save(pokemonAux);
        }
        return null;
    }

    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }

}
