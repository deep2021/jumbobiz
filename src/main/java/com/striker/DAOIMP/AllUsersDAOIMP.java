package com.striker.DAOIMP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.striker.DAOI.AllUserListDAOI;
import com.striker.DTO.UsersListDTO;


public class AllUsersDAOIMP implements AllUserListDAOI {

		private static final String selectQuery="select id, First_Name,Email,Mobile,Registration_Date,Role from registration_customer_data where Role Not In ('Supplier','Admin','StockManager')";
		 
		private JdbcTemplate template;  
		  
		
       public AllUsersDAOIMP(DataSource dataSource){
		   
    	   template=new JdbcTemplate(dataSource);
		}
            // view all userslist
		public List<UsersListDTO> allUser() {
			System.out.println("inside all user method");
			
			    List<UsersListDTO> listContact = template.query(selectQuery, new RowMapper<UsersListDTO>() {

					public UsersListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						UsersListDTO dto = new UsersListDTO();
						dto.setId(rs.getInt(1));
						dto.setFname(rs.getString(2));
						dto.setEmail(rs.getString(3));
						dto.setMobile(rs.getLong(4));
						dto.setDate((rs.getString(5)));
						dto.setRole(rs.getString(6));
						/*dto.setCity(rs.getString(7));
						dto.setState(rs.getString(8));
						dto.setCountry(rs.getString(9));
					*///	System.out.println("hiii");
						
						return dto;
					}
			
			    });
			 
			    return listContact;
		
		}
              //delete a perticular user
		public int deleteUser(int id) {
			 String deleteQuery="delete from registration_customer_data where id='"+id+"' ";
			   return template.update(deleteQuery);  
		
		}
             //  view Supplier list
		public List<UsersListDTO> allSuppliers() {
			String query="select id, First_Name,Email,Mobile,Registration_Date,Role from registration_customer_data where Role Not In ('User','Admin','StockManager')";
			  List<UsersListDTO> listContact = template.query(query, new RowMapper<UsersListDTO>() {
             		public UsersListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						UsersListDTO dto = new UsersListDTO();
						dto.setId(rs.getInt(1));
						dto.setFname(rs.getString(2));
						dto.setEmail(rs.getString(3));
						dto.setMobile(rs.getLong(4));
						dto.setDate(rs.getString(5));
						dto.setRole(rs.getString(6));
						/*dto.setCity(rs.getString(7));
						dto.setState(rs.getString(8));
						dto.setCountry(rs.getString(9));
						*/
						return dto;
					}
			
			    });
			 
			    return listContact;
		
		}
          //delete a perticular supplier
		public int deleteSupplier(int id) {
			 String deleteQuery="delete from registration_customer_data where id='"+id+"' ";
			 return template.update(deleteQuery);  
		}
        //make a supplier from userslist
		public boolean makeSupplier(int id) {
			/*String query="select Role from registration_customer_data where id=?";
			String role = (String) template.queryForObject(
					query, new Object[] { id }, String.class);
           System.out.println("name=="+role);
           
*/         String role="Supplier";
			template.update(
                   "update registration_customer_data set Role = ? where id = ?", 
                   role, id);
          boolean flag=true;
            return flag;
		}
} 