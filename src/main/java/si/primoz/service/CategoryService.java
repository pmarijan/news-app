package si.primoz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import si.primoz.domain.Category;
import si.primoz.repository.ICategoryRepository;

/**
 *
 * @author pmarijan
 */
@Component
@Transactional(readOnly = true)
public class CategoryService {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);
    
    @Autowired
    private ICategoryRepository categoryRepository;
    
    public Iterable<Category> getList() {
        LOG.info("BEGIN ()");
        
        return categoryRepository.findAll();
    }
}
