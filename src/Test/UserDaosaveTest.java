package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ds.contactapp.config.SpringRootConfig;
import com.ds.contactapp.dao.UserDao;
import com.ds.contactapp.domain.User;

public class UserDaosaveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
UserDao userdao=ctx.getBean(UserDao.class);
//user details will be taken from user registration form
User u=new User();//it will be done by controller once form is submitted.values will be bind to domain object and sent to Userdao.
u.setName("alam");
u.setPhone("789");
u.setAddress("kolkata");
u.setEmail("p@x");
u.setLoginname("rocky");
u.setLoginstatus(1);//active
u.setRole(2);//admin role assigned
u.setPassword("alam");
userdao.save(u);
System.out.println(" user hs been added");
	}

}
