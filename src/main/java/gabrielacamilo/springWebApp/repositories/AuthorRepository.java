package gabrielacamilo.springWebApp.repositories;

import gabrielacamilo.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Long> {
}
