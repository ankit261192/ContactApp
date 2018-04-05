package com.ds.contactapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ContactAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	//for Spring root configurations.They can be multiple in number
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{SpringRootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{SpringWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// to specify mapping for front controller i.e. dispatcher servlet
		return new String[]{"/"};
	}
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//very important as it is the first method to be called on startup
		// we can configure global task if required as it is servlet contaxt object
		super.onStartup(servletContext);
	}

}
