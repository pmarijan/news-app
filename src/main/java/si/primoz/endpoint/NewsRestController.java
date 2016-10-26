package si.primoz.endpoint;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping(value = "/{id}")
    public News get(@PathVariable(value = "id", required = true) Integer id) {
        return newsService.get(id);
    }
    
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id", required = true) Integer id) {
        newsService.delete(id);
    }
    
    @GetMapping
    public Iterable<News> getList() {
        return newsService.getList();
    }
    
    @PutMapping(value = "/{id}")
    public News update(@PathVariable(value = "id", required = true) Integer id, 
                        @RequestBody @Valid News news) {
        return newsService.update(id, news);
    }

    @PostMapping
    public News create(@RequestBody(required = true) @Valid News news) {
        return newsService.create(news);
    }
}
