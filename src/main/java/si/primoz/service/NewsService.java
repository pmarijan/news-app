package si.primoz.service;

import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import si.primoz.domain.News;
import si.primoz.repository.INewsRepository;

/**
 *
 * @author pmarijan
 */
@Component
@Transactional(readOnly = true)
public class NewsService {
    private static final Logger LOG = LoggerFactory.getLogger(NewsService.class);
    
    @Autowired
    private INewsRepository newsRepository;
    
    public News get(Integer id) {
        LOG.info("BEGIN (id={})", id);
        
        Objects.requireNonNull(id, "Parameter Id must not be null!");
        
        return newsRepository.findOne(id);
    }
    
    public Iterable<News> getList() {
        LOG.info("BEGIN");
        
        return newsRepository.findAll();
    }
    
    @Transactional
    public News create(News news) {
        LOG.info("BEGIN (news={})", news);
        
        //set id to null because we want to create new record, not update existing one
        news.setId(null);

        return newsRepository.save(news);
    }
    
    @Transactional
    public News update(Integer id, News news) {
        LOG.info("BEGIN (id={}, news={})", id, news);
        
        Objects.requireNonNull(id, "Parameter Id must not be null!");

        news.setId(id);
        return newsRepository.save(news);
    }
    
    @Transactional
    public void delete(Integer id) {
        LOG.info("BEGIN (id={})", id);
        
        Objects.requireNonNull(id, "Parameter Id must not be null!");
        
        newsRepository.delete(id);
    }
}
