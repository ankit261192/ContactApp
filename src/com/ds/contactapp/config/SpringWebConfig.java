package com.ds.contactapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@ComponentScan(basePackages={"com.ds"})
@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter {
	
@Override
//to make Spring access static resources like css,javascript etc.
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// TODO 
	registry.addResourceHandler("/Static/**").addResourceLocations("/Static/");
}
@Bean
public ViewResolver viewResolver() {
	
	//to access pages under webinf.cannot be accessed directly from browser
	InternalResourceViewResolver vr=new InternalResourceViewResolver();
vr.setViewClass(JstlView.class);
vr.setPrefix("/WEB-INF/view/");
vr.setSuffix(".jsp");
return vr;
}
}
