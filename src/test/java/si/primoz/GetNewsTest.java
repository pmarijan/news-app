package si.primoz;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import si.primoz.domain.News;
import si.primoz.repository.INewsRepository;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import si.primoz.domain.Category;
import si.primoz.service.NewsService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {NewsService.class})
@DataJpaTest
public class GetNewsTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NewsService newsService;

    private Category category;
    private News news;
    
    @Before
    public void init() {
        category = this.entityManager.persist(new Category(null, "category"));
        news = this.entityManager.persist(new News(null, "title", "text", category));
    }
    
    @Test
    public void testOk() {
        News n = newsService.get(news.getId());
        assertNotNull("News object must not be null!", n);
        assertNotNull("News date must not be null!", n.getDate());
        assertThat(n.getText()).isEqualTo("text");
        assertThat(n.getTitle()).isEqualTo("title");
        assertNotNull(n.getCategory());
        assertThat(n.getCategory().getName()).isEqualTo(category.getName());
        assertThat(n.getCategory().getId()).isEqualTo(category.getId());
    }

    @Test
    public void testNotExist() {
        News news = this.newsService.get(4356641);
        assertNull("News object must be null!", news);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testIdNull() {
        this.newsService.get(null);

    }
}
