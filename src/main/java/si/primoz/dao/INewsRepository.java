package si.primoz.dao;

import org.springframework.data.repository.CrudRepository;
import si.primoz.domain.News;

/**
 *
 * @author primoz
 */
public interface INewsRepository extends CrudRepository<News, Integer> {
    
}
