package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ds.contactapp.config.SpringRootConfig;
import com.ds.contactapp.domain.User;
import com.ds.contactapp.services.UserService;

public class UserServiceRegisterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
UserService userservice=ctx.getBean(UserService.class);
//user details will be taken from user registration form
User u=new User();//it will be done by controller once form is submitted.values will be bind to domain object and sent to Userdao.
u.setName("soumallya");
u.setPhone("4567");
u.setAddress("jammu");
u.setEmail("s@xy");
u.setLoginname("sabjiman");
u.setLoginstatus(UserService.LOGIN_STATUS_ACTIVE);//active
u.setRole(UserService.ADMIN_ROLE);//admin role assigned
u.setPassword("sabjiman");
userservice.register(u);
System.out.println(" user has been registered");
	}

}
