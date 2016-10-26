/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.primoz.endpoint;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping
    public Iterable<Category> getList() {
        return categoryService.getList();
    }
}
