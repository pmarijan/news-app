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

@RunWith(SpringRunner.class)
@DataJpaTest
public class GetNewsTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private INewsRepository newsRepository;

    @Before
    public void init() {
        this.entityManager.persist(new News(null, "title", "text", "category"));
    }
    
    @Test
    public void testOk() {
        News news = this.newsRepository.findOne(1);
        assertNotNull(news);
        assertNotNull(news.getDate());
        assertThat(news.getText()).isEqualTo("text");
        assertThat(news.getTitle()).isEqualTo("title");
        assertThat(news.getCategory()).isEqualTo("category");
    }

    @Test
    public void testNotExist() {
        News news = this.newsRepository.findOne(4356641);
        assertNull(news);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testIdNull() {
        this.newsRepository.findOne(null);

    }
}
