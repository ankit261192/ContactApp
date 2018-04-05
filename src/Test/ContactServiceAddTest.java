package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ds.contactapp.config.SpringRootConfig;
import com.ds.contactapp.domain.Contact;
import com.ds.contactapp.domain.User;
import com.ds.contactapp.services.ContactService;
import com.ds.contactapp.services.UserService;

public class ContactServiceAddTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
ContactService contactservice=ctx.getBean(ContactService.class);
//user details will be taken from user registration form
Contact c=new Contact();//it will be done by controller once form is submitted.values will be bind to domain object and sent to Userdao.
c.setAddress("dadar");
c.setEmail("s@xx");
c.setName("ram");
c.setPhone("567");
c.setRemark("good");
contactservice.save(c);
System.out.println(" contact has been added");
	}

}
