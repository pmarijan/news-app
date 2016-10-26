package si.primoz.repository;

import org.springframework.data.repository.CrudRepository;
import si.primoz.domain.Category;

/**
 *
 * @author pmarijan
 */
public interface ICategoryRepository extends CrudRepository<Category, Integer> {
    
}
