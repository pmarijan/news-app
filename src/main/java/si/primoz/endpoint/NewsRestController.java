package si.primoz.endpoint;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.primoz.domain.News;
import si.primoz.repository.INewsRepository;

/**
 *
 * @author primoz
 */
@RestController
@RequestMapping("/api/news")
public class NewsRestController {
    
    @Autowired
    private INewsRepository newsRepository;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public News get(@PathVariable(value = "id", required = true) Integer id) {
        return new News(1, "title", "content text", new Date(), "Category");
        //TODO: return newsRepository.findOne(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id", required = true) Integer id) {
        newsRepository.delete(id);
    }
    
    @RequestMapping
    public Iterable<News> getAll() {
        List<News> news = Arrays.asList(new News(1, "title 1", "content text", new Date(), "Category 1"), 
                                        new News(1, "title 2", "content text", new Date(), "Category 2"));
        
        return news;
//        return newsRepository.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void update(@PathVariable(value = "id", required = true) Integer id, News news) {
        newsRepository.save(news);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public News create(News news) {
        return newsRepository.save(news);
    }
}
