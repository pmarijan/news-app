package si.primoz.repository;

import org.springframework.data.repository.CrudRepository;
import si.primoz.domain.News;

/**
 *
 * @author primoz
 */
public interface INewsRepository extends CrudRepository<News, Integer> {
    
}
