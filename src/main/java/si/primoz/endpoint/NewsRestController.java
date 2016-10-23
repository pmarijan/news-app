package si.primoz.endpoint;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import si.primoz.domain.News;
import si.primoz.dao.INewsRepository;

/**
 *
 * @author primoz
 */
@RestController
@RequestMapping("/news")
public class NewsRestController {
    
    @Autowired
    private INewsRepository newsRepository;
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public News get(@PathVariable(name = "id", required = true) Integer id) {
        return newsRepository.findOne(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id", required = true) Integer id) {
        newsRepository.delete(id);
    }
    
    @RequestMapping
    public Iterable<News> getAll() {
        return newsRepository.findAll();
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public void update(News news) {
        newsRepository.save(news);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public News create(News news) {
        return newsRepository.save(news);
    }
}
