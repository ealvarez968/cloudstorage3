
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.model.UsersMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/beans.xml")
public class UsersMapperIntegrationTest {

    @Autowired
    UsersMapper usersMapper;


    @Test
    public void insertValue(){

        Users newuser = new Users();
        newuser.setUserid(3);;
        newuser.setFirstname("Eduard");
        newuser.setLastname("Alvarez");
        newuser.setPassword("Hola");
        newuser.setSalt("holasalt");
        newuser.setUsername("user2");
        usersMapper.insertUsers(newuser);

    }

     @Test
     public void whenRecordsInDatabase_shouldReturnUsersWithGivenId() {
        Users u = usersMapper.getUser(1);
        Assertions.assertThat(u.getUserid()).isEqualTo(1);
    }

    @Test
    public void deleteAUser(){
        for(Users i : usersMapper.getUsers()){
            System.out.println("Nombre::"+i.getFirstname()+" Id:::"+i.getUserid());
        }
        usersMapper.deleteUser(2);
        usersMapper.updateUsername("Soy el sobreviviente",1);

        System.out.println("==========================");
        for(Users i : usersMapper.getUsers()){
            System.out.println("NOmbre::"+i.getFirstname()+" Id:::"+i.getUserid());
        }
        System.out.println("==========================");
    }




}
