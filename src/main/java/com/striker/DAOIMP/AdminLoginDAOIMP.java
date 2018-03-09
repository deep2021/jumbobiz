package com.striker.DAOIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.striker.DAOI.AdminLoginDAOI;
import com.striker.DTO.LoginDTO;
import com.striker.DTO.UsersListDTO;
import com.striker.connection.GetConnection123;

 public class AdminLoginDAOIMP implements AdminLoginDAOI {

	private JdbcTemplate template;  
	 public AdminLoginDAOIMP(DataSource dataSource){
	
			template=new JdbcTemplate(dataSource);
		}

	public LoginDTO login(LoginDTO dto) {
		
		 String selectQuery="select Password,Role from registration_customer_data where Email=?";
	
			return template.queryForObject(selectQuery, BeanPropertyRowMapper.newInstance(LoginDTO.class), dto.getUserName());
		}

	@Override
	public UsersListDTO getProfile() {
		String role="admin";
		 String selectQuery="select id,First_Name,Last_Name,Email, Mobile from registration_customer_data where Role=?";
		 
		  //  return template.queryForObject(selectQuery, new Object[]{role},new BeanPropertyRowMapper<UsersListDTO>(UsersListDTO.class));  
		 UsersListDTO dto=new UsersListDTO();
		try{
			
			 Connection connection=GetConnection123.gettingConnection();
			 PreparedStatement ps=connection.prepareStatement(selectQuery);
			 ps.setString(1, role);
			 ResultSet rs=ps.executeQuery();
			
			 while(rs.next()){
				 dto.setId(rs.getInt(1));
				 dto.setFname(rs.getString(2));
				 dto.setLname(rs.getString(3));
				 dto.setEmail(rs.getString(4));
				 dto.setMobile(rs.getLong(5));
				 /*dto.setCity(rs.getString(6));
				 dto.setState(rs.getString(7));
				 dto.setCountry(rs.getString(8));
				 */
			 }
			
		}
		catch (Exception e) {
		      e.printStackTrace();
		}
			return dto;
       
	}

	@Override
	public int editSaveProfile(UsersListDTO dto) {
		
		String sql="update registration_customer_data set First_Name='"+dto.getFname()+"',Last_Name='"+dto.getLname()+"', Email='"+dto.getEmail()+"', Mobile='"+dto.getMobile()+"'where id='"+dto.getId()+"'";  
		    return template.update(sql); 
	}}