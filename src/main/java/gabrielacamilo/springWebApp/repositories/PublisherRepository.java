package gabrielacamilo.springWebApp.repositories;

import gabrielacamilo.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
