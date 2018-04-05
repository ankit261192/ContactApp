package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ds.contactapp.config.SpringRootConfig;
import com.ds.contactapp.dao.UserDao;
import com.ds.contactapp.domain.User;

public class UserDaofindbyidTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
UserDao userdao=ctx.getBean(UserDao.class);
//user details will be taken from user update page
//User u=new User();//it will be done by controller once form is submitted.values will be bind to domain object and sent to Userdao.
User u=userdao.findById(3);
System.out.println("user has been found");
System.out.println(u.getAddress());
System.out.println(u.getEmail());
System.out.println(u.getLoginname());
System.out.println(u.getName());
System.out.println(u.getPhone());
System.out.println(u.getLoginstatus());
System.out.println(u.getRole());
System.out.println(u.getUserid());
	}

}
