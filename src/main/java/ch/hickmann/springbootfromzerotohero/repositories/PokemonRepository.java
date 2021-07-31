package ch.hickmann.springbootfromzerotohero.repositories;

import ch.hickmann.springbootfromzerotohero.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
