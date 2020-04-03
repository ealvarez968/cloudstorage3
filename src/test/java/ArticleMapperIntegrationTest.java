

import com.baeldung.mybatis.spring.*;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = PersistenceConfig.class)
@ContextConfiguration(locations = "classpath:/beans.xml")
public class ArticleMapperIntegrationTest {

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void whenRecordsInDatabase_shouldReturnArticleWithGivenId() {
        Article article = articleMapper.getArticle(1L);
        Assertions.assertThat(article).isNotNull();
        Assertions.assertThat(article.getId()).isEqualTo(1L);
        Assertions.assertThat(article.getAuthor()).isEqualTo("Baeldung");
        Assertions.assertThat(article.getTitle()).isEqualTo("Working with MyBatis in Spring");


    }
}
