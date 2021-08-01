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

}
