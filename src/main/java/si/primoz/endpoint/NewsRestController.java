package si.primoz.endpoint;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import si.primoz.domain.News;
import si.primoz.service.NewsService;

/**
 *
 * @author primoz
 */
@RestController
@RequestMapping("/api/news")
public class NewsRestController {
    
    @Autowired
    private NewsService newsService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public News get(@PathVariable(value = "id", required = true) Integer id) {
        return newsService.get(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id", required = true) Integer id) {
        newsService.delete(id);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<News> getList() {
        return newsService.getList();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public News update(@PathVariable(value = "id", required = true) Integer id, 
                        @RequestBody @Valid News news) {
        return newsService.update(id, news);
    }

    @RequestMapping(method = RequestMethod.POST)
    public News create(@RequestBody(required = true) @Valid News news) {
        return newsService.create(news);
    }
}
