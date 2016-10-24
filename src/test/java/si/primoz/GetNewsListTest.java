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
import org.springframework.test.context.junit4.SpringRunner;
import si.primoz.domain.News;
import si.primoz.repository.INewsRepository;

/**
 *
 * @author pmarijan
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class GetNewsListTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private INewsRepository newsRepository;

    @Before
    public void init() {
        this.entityManager.persist(new News(null, "title1", "text1", "category1"));
        this.entityManager.persist(new News(null, "title2", "text2", "category2"));
        this.entityManager.persist(new News(null, "title3", "text3", "category3"));
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
