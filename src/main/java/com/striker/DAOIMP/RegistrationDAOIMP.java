package com.striker.DAOIMP;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.striker.DAOI.RegistrationDAOI;
import com.striker.DTO.RegistrationDTO;

//Registration  of client
public class RegistrationDAOIMP implements RegistrationDAOI{

	
	private JdbcTemplate template;
	public RegistrationDAOIMP(DataSource dataSource) {
		template=new JdbcTemplate(dataSource);
	}
     //Register client 
	public boolean registration(RegistrationDTO user) {
		String query="insert into registration_customer_data(First_Name,Last_Name,Email,Mobile,Password,ConfirmPassword,Registration_Date,Role) values(?,?,?,?,?,?,?,?)";
		template.update(query, new Object[] { user.getFname(), user.getLname(), user.getEmail(),
				user.getMobile(), user.getPassword(), user.getRepassword(), user.getDate(),user.getRole() });
		boolean flag=true;
		return flag;
	}
}