package com.striker.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.striker.DAOI.AdminLoginDAOI;
import com.striker.DAOI.AllUserListDAOI;
import com.striker.DAOI.CategoryDAOI;
import com.striker.DAOI.ProductDAOI;
import com.striker.DAOI.RegistrationDAOI;
import com.striker.DAOI.SubCategoryDAOI;
import com.striker.DAOIMP.AdminLoginDAOIMP;
import com.striker.DAOIMP.AllUsersDAOIMP;
import com.striker.DAOIMP.CategoryDAOIMP;
import com.striker.DAOIMP.ProductDAOIMP;
import com.striker.DAOIMP.RegistrationDAOIMP;
import com.striker.DAOIMP.SubCategoryDAOIMP;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.striker.controller")
public class MvcConfiguration extends  WebMvcConfigurerAdapter{

	//set Internal resources
	 @Bean
	    public ViewResolver viewResolver() {
		    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	 
	 //View controller Registry Or welcome files
	 @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("Home");
	  }

	 //static resources
	 @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
				.addResourceLocations("/assets/");
		registry.addResourceHandler("/resources/**")
		        .addResourceLocations("/resources/");
		
	}
	 //multipart configuration
	 @Bean
		public MultipartResolver multipartResolver(){
			CommonsMultipartResolver resolver = new CommonsMultipartResolver();
			resolver.setDefaultEncoding("utf-8");
			resolver.setMaxUploadSize(1024000000);
			return resolver;
		}
	 //database configuration with datasource
	 @Bean
	    public DataSource getDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        //set driver Class name
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        //set url
	        dataSource.setUrl("jdbc:mysql://localhost:3306/jumboproject");
	        //set username
	        dataSource.setUsername("root");
	        // set password
	        dataSource.setPassword("123456");
	         return dataSource;
	    }
	   //all userslist
	   @Bean
	    public AllUserListDAOI getContactDAO() {
	        return new AllUsersDAOIMP(getDataSource());
	    }
	   //Category
	   @Bean
	    public CategoryDAOI getCategoryDAO() {
	        return new CategoryDAOIMP(getDataSource());
	    }
	   //Admin Login
	   @Bean
	    public AdminLoginDAOI getAdminDAO() {
	        return new AdminLoginDAOIMP(getDataSource());
	    }
	   //SubCategory
	   @Bean
	    public SubCategoryDAOI getSubCategoryDAO() {
	        return new SubCategoryDAOIMP(getDataSource());
	    }
	   //AddProduct
	   @Bean
	    public ProductDAOI getProductDAO() {
	        return new ProductDAOIMP(getDataSource());
	    }
	   //Registration
	   @Bean
	    public RegistrationDAOI getRegistrationDAO() {
	        return new RegistrationDAOIMP(getDataSource());
	    }
}