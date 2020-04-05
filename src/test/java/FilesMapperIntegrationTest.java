import com.udacity.jwdnd.course1.cloudstorage.model.FilesMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/beans.xml")
public class FilesMapperIntegrationTest {

    @Autowired
    FilesMapper filesMapper;

    @Test
    public void insertValue(){
        int size =filesMapper.getFilesByUserId(1).size();
        Assertions.assertThat(size).isEqualTo(0);
    }
}
