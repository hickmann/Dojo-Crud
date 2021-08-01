package ch.hickmann.springbootfromzerotohero.controllers;

import ch.hickmann.springbootfromzerotohero.entities.Pokemon;
import ch.hickmann.springbootfromzerotohero.services.PokedexService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pokedex")
public class PokedexControllerRest {

    private final PokedexService pokedexService;

    public PokedexControllerRest(PokedexService pokedexService) {
        this.pokedexService = pokedexService;
    }

    @PostMapping
    public ResponseEntity<Pokemon> savePokemon(
            @RequestBody Pokemon pokemon) {
        Pokemon pokemonCreated = pokedexService.savePokemon(pokemon);

        return new ResponseEntity<>(pokemonCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> findAllPokemons() {
        List<Pokemon> pokemonList = pokedexService.findAllPokemons();

        if (pokemonList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(pokemonList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> findPokemon(
            @PathVariable("id") long id
    ) {
        Pokemon pokemon = pokedexService.findPokemonById(id);

        if (pokemon != null)
            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(
            @PathVariable("id") long id,
            @RequestBody Pokemon pokemon) {
        Pokemon pokemonUpdated = pokedexService.updatePokemon(id, pokemon);

        if (pokemonUpdated != null)
            return new ResponseEntity<>(pokemonUpdated, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pokemon> deletePokemon(
            @PathVariable("id") long id) {

        try {
            pokedexService.deletePokemon(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
