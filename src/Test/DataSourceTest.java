package Test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ds.contactapp.config.SpringRootConfig;

public class DataSourceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
	DataSource ds=ctx.getBean(DataSource.class);
	JdbcTemplate jt=new JdbcTemplate(ds);
	String sql="insert into user(name,phone,email,address,loginname,password) values(?,?,?,?,?,?)";
	Object[] param=new Object[] {"ankit","12345","a@x","vizag","ak","pwd"};
	jt.update(sql, param);
	System.out.println("sql executed");
	}

}
