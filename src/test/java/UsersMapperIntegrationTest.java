
import com.baeldung.mybatis.spring.Users;
import com.baeldung.mybatis.spring.UsersMapper;
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



   // @Test
   // public void whenRecordsInDatabase_shouldReturnUsersWithGivenId() {
        //Users u = usersMapper.getUsers(1);
        //Assertions.assertThat(u.getUserid()).isEqualTo(1);

        /*Users newuser = new Users();
        newuser.setUserid(3);;
        newuser.setFirstname("Eduard");
        newuser.setLastname("Alvarez");
        newuser.setPassword("Hola");
        newuser.setSalt("holasalt");
        newuser.setUsername("ealvarez");
         usersMapper.insertUsers(3, "Eddie", "Alvarez");*/

        //Users u1 = usersMapper.getUsers(3);
        //Assertions.assertThat(u1.getFirstname()).isEqualTo("Eduard");


    //}

    @Test
    public void insertValue(){

        Users newuser = new Users();
        newuser.setUserid(2);;
        newuser.setFirstname("Eduard");
        newuser.setLastname("Alvarez");
        newuser.setPassword("Hola");
        newuser.setSalt("holasalt");
        newuser.setUsername("user2");
        usersMapper.insertUsers(newuser);

    }

     @Test
     public void whenRecordsInDatabase_shouldReturnUsersWithGivenId() {
        Users u = usersMapper.getUsers(1);
        Assertions.assertThat(u.getUserid()).isEqualTo(1);



    }

    @Test
    public void seeIfReturnsId() {
        Users newuser = new Users();
        newuser.setUserid(3);;
        newuser.setFirstname("Eduard");
        newuser.setLastname("Alvarez");
        newuser.setPassword("Hola");
        newuser.setSalt("holasalt");
        newuser.setUsername("user1");

        int id = usersMapper.insertUsersReturningId(newuser);
        System.out.println("Id --- "+id);


    }
}
