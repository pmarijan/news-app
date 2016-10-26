package si.primoz;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import si.primoz.domain.Category;
import si.primoz.domain.News;
import si.primoz.repository.INewsRepository;
import si.primoz.service.NewsService;

/**
 *
 * @author pmarijan
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {NewsService.class})
@DataJpaTest
public class GetNewsListTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private INewsRepository newsRepository;

    private Category category1;
    private Category category2;
    
    @Before
    public void init() {
        category1 = this.entityManager.persist(new Category(null, "category1"));
        category2 = this.entityManager.persist(new Category(null, "category2"));
        
        this.entityManager.persist(new News(null, "title1", "text1", category1));
        this.entityManager.persist(new News(null, "title2", "text2", category2));
        this.entityManager.persist(new News(null, "title3", "text3", category2));
    }
    
    @Test
    public void testNotEmpty() {
        Iterable<News> newsList = newsRepository.findAll();
        List<News> news = Lists.newArrayList(newsList);
        
        assertNotNull(newsList);
        assertFalse(news.isEmpty());
        assertTrue(news.size() == 3);
    }
    
    @Test
    public void testEmpty() {
        newsRepository.deleteAll();
        
        Iterable<News> newsList = newsRepository.findAll();
        List<News> news = Lists.newArrayList(newsList);
        
        assertNotNull(newsList);
        assertTrue(news.isEmpty());
    }
}
