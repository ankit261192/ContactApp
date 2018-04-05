package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ds.contactapp.config.SpringRootConfig;
import com.ds.contactapp.dao.UserDao;
import com.ds.contactapp.domain.User;

public class UserDaoupdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
UserDao userdao=ctx.getBean(UserDao.class);
//user details will be taken from user update page
User u=new User();//it will be done by controller once form is submitted.values will be bind to domain object and sent to Userdao.
u.setName("samar");
u.setPhone("1234");
u.setAddress("ram_pur");
u.setEmail("s@pqr");
//u.setLoginname("sammy");
u.setLoginstatus(1);//active
u.setRole(1);//admin role assigned
//u.setPassword("sam");
u.setUserid(3);
userdao.update(u);
System.out.println(" user has been updated");
	}

}
