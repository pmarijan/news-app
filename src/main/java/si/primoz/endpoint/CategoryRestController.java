package si.primoz.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.primoz.domain.Category;
import si.primoz.service.CategoryService;

/**
 *
 * @author pmarijan
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public Iterable<Category> getList() {
        return categoryService.getList();
    }
}
